package ru.job4j.ood.srp.report;

import com.google.gson.*;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.function.Predicate;

public class ReportJSON implements Report {
    private final Store store;
    private final Gson context;

    public ReportJSON(Store store, Gson context) {
        this.store = store;
        this.context = context;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return context.toJson(store);

    }

    public static class CalendarSerializer implements JsonSerializer<Calendar> {

        DateTimeParser<Calendar> dateTimeParser;

        public CalendarSerializer(DateTimeParser<Calendar> dateTimeParser) {
            this.dateTimeParser = dateTimeParser;
        }

        @Override
        public JsonElement serialize(Calendar calendar, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(dateTimeParser.parse(calendar));
        }
    }
}
