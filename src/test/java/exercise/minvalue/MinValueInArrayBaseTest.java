package exercise.minvalue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class MinValueInArrayBaseTest {
    protected final MinValueInArray minValueInArray;

    public MinValueInArrayBaseTest(final MinValueInArray minValueInArray) {
        this.minValueInArray = minValueInArray;
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
