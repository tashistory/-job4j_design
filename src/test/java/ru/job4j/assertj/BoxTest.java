package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import org.assertj.core.data.Percentage;
import static org.assertj.core.api.Assertions.*;
class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name)
                .isNotEmpty()
                .isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 7);
        String name = box.whatsThis();
        assertThat(name)
                .doesNotContain("Unknown object")
                .isEqualTo("Tetrahedron");
    }

    @Test
    void chekNumberOfVertices() {
        Box box = new Box(4, 7);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices)
                .isEven()
                .isNotZero()
                .isEqualTo(4);
    }

    @Test
    void chekNumberOfVerticesisNull() {
        Box box = new Box(0, 7);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices)
                .isZero()
                .isEqualTo(0);
    }

    @Test
    void checkBooleanIsTrue() {
        Box box = new Box(0, 7);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void checkBooleanIsFalse() {
        Box box = new Box(3, 7);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void checkDoubleChainThen84dot87() {
        Box box = new Box(4, 7);
        double result = box.getArea();
        assertThat(result).isEqualTo(84.87d, withPrecision(0.006d))
                .isCloseTo(84.88d, withPrecision(0.01d))
                .isCloseTo(84.87d, Percentage.withPercentage(1.0d))
                .isGreaterThan(84.87d)
                .isLessThan(84.88d);
    }

    @Test
    void checkDoubleChainThen1256dot64() {
        Box box = new Box(0, 10);
        double result = box.getArea();
        assertThat(result).isEqualTo(1256.64d, withPrecision(0.006d))
                .isCloseTo(1256.63d, withPrecision(0.01d))
                .isCloseTo(1256.63d, Percentage.withPercentage(1.0d))
                .isGreaterThan(1256.63d)
                .isLessThan(1256.64d);
    }
}