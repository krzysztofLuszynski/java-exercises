package exercise.minvalue;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MinValueInArrayTest {
    private final MinValueInArray minValueInArray = new MinValueInArray();

    @Test
    void nullArray() {
        assertThrows(IllegalArgumentException.class,
                () -> minValueInArray.minValue(null),
                "Null or empty input array");
    }

    @Test
    void emptyArray() {
        assertThrows(IllegalArgumentException.class,
                () -> minValueInArray.minValue(new int[0]),
                "Null or empty input array");
    }

    @Test
    void oneElementArray() {
        final int min = minValueInArray.minValue(new int[]{1});
        assertEquals(1, min);
    }

    @Test
    void twoElementsArray() {
        final int min = minValueInArray.minValue(new int[]{1, 2});
        assertEquals(1, min);
    }

    @Test
    void twoElementsArrayOpposite() {
        final int min = minValueInArray.minValue(new int[]{2, 1});
        assertEquals(1, min);
    }

    @Test
    void fiveElementsArray() {
        final int min = minValueInArray.minValue(new int[]{1, 2, -3, 4, 5});
        assertEquals(-3, min);
    }

    @Test
    void fiveElementsArray1() {
        final int min = minValueInArray.minValue(new int[]{1, 2, 5, 4, -3});
        assertEquals(-3, min);
    }
}
