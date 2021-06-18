package exercise.intarray.minvalue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

abstract class MinValueInArrayStreamBaseTest extends MinValueInArrayBaseTest {
    public MinValueInArrayStreamBaseTest(final MinValueInArray minValueInArray) {
        super(minValueInArray);
    }

    @Test
    void nullArray() {
        assertThatThrownBy(() -> minValueInArray.minValue(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void emptyArray() {
        assertThatThrownBy(() -> minValueInArray.minValue(new int[0]))
                .isInstanceOf(CanNotFindMinValueException.class)
                .hasMessage("Can not find min in IntStream !");
    }
}
