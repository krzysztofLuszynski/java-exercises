package exercise.intarray.minvalue;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MinValueInArrayStreamDefaultImplTest extends MinValueInArrayBaseTest{
    public MinValueInArrayStreamDefaultImplTest() {
        super(new MinValueInArrayStreamDefaultImpl());
    }

    @Test
    void nullArray() {
        assertThrows(NullPointerException.class,
                () -> minValueInArray.minValue(null));
    }

    @Test
    void emptyArray() {
        assertThrows(CanNotFindMinValueException.class,
                () -> minValueInArray.minValue(new int[0]),
                "Can not find min in IntStream");
    }
}
