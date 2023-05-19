package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenRemoveIf() {
        ListUtils.removeIf(input, el -> el.equals(3));
        assertThat(input).hasSize(1).containsSequence(1);
    }
    @Test
    void wrenReplaceIf() {
        ListUtils.replaceIf(input, el -> el.equals(3), 4);
        assertThat(input).hasSize(2).containsSequence(1, 4);
    }
    @Test
    void wrenRemoveAll() {
        ListUtils.addBefore(input, 1, 2);
        ListUtils.addBefore(input, 2, 4);
        ListUtils.addBefore(input, 2, 5);
        ListUtils.removeAll(input, new ArrayList<>(Arrays.asList(2, 4, 5)));
        assertThat(input).hasSize(2).containsSequence(1, 3);
    }

    @Test
    void whenAddAfterEnd() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 3, 2);
    }
}