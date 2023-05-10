package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("Иван", "Денис", "Алла");
        assertThat(list).hasSize(3)
                .contains("Алла")
                .contains("Иван", Index.atIndex(0));
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("Иван", "Денис", "Алла");
        assertThat(set).hasSize(3)
                .contains("Алла")
                .first().isEqualTo("Денис");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("Иван", "Денис", "Алла");
        assertThat(map).hasSize(3)
                .containsKeys("Иван", "Денис", "Алла")
                .containsValues(0, 1, 2)
                .containsEntry("Денис", 1);
    }
}