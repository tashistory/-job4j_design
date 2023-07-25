package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws IOException, SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws IOException, ClassNotFoundException, SQLException {
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(in);
        }
        Class.forName(properties.getProperty("hibernate.connection.driver_class"));
        String url = properties.getProperty("hibernate.connection.url");
        String login = properties.getProperty("hibernate.connection.username");
        String password = properties.getProperty("hibernate.connection.password");
        connection = DriverManager.getConnection(url, login, password);
    }

    private void initAction(String command) throws SQLException {
        try (var statement = connection.createStatement()) {
            statement.execute(String.format(command));
        }
    }

    public void createTable(String tableName) throws Exception {
        initAction(String.format("CREATE TABLE IF NOT EXISTS %s ()", tableName));
    }

    public void dropTable(String tableName) throws Exception {
        initAction(String.format("DROP TABLE %s", tableName));
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        initAction(String.format("ALTER TABLE %s ADD COLUMN  %s %s", tableName, columnName, type));
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        initAction(String.format("ALTER TABLE %s DROP COLUMN %s", tableName, columnName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        initAction(String.format("ALTER TABLE %s RENAME COLUMN %s TO %s", tableName, columnName, newColumnName));
    }


    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        TableEditor table = new TableEditor(new Properties());
        table.initConnection();
        table.dropTable("test");
        table.createTable("test");
        table.addColumn("test", "id", "INTEGER");
        table.addColumn("test", "name", "varchar(255)");
        table.addColumn("test", "name2", "varchar(255)");
        table.dropColumn("test", "name2");
        table.renameColumn("test", "name", "fio");
        System.out.println(table.getTableScheme("test"));
    }
}