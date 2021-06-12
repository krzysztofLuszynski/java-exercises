package exercise.minvalue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MinValueInArrayBasicImplTest extends MinValueInArrayBaseTest {
    public MinValueInArrayBasicImplTest() {
        super(new MinValueInArrayBasicImpl());
    }

    @Test
    void nullArray() {
        assertThrows(CanNotFindMinValueException.class,
                () -> minValueInArray.minValue(null),
                "Null or empty input array");
    }

    @Test
    void emptyArray() {
        assertThrows(CanNotFindMinValueException.class,
                () -> minValueInArray.minValue(new int[0]),
                "Null or empty input array");
    }
}
