package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithComment() {
        String path = "./data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.driver_class")).isEqualTo("org.postgresql.Driver");
    }
    @Test
    void whenPairWithCommentAndDublValue() {
        String path = "./data/dubl_value.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.username")).isEqualTo("postgres=1");
    }
    @Test
    void whenPairWithCommentAndDublValueWithoutSecondValue() {
        String path = "./data/dubl_value_without_second_value.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.username")).isEqualTo("postgres=1");
    }
    @Test
    void whenKeyWithoutValue() {
        String path = "./data/key_without_value.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("hibernate.connection.username= Error");
    }
    @Test
    void whenValueWithoutKey() {
        String path = "./data/value_without_key.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("=postgres Error");
    }
    @Test
    void whenWithoutKeyAndValue() {
        String path = "./data/without_key_and_value.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("= Error");
    }
}