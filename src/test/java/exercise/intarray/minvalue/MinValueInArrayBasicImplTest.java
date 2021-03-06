package exercise.intarray.minvalue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MinValueInArrayBasicImplTest extends MinValueInArrayBaseTest {
    public MinValueInArrayBasicImplTest() {
        super(new MinValueInArrayBasicImpl());
    }

    @Test
    void nullArray() {
        assertThatThrownBy(() -> minValueInArray.minValue(null))
                .isInstanceOf(CanNotFindMinValueException.class)
                .hasMessage("Null or empty input array !");
    }

    @Test
    void emptyArray() {
        assertThatThrownBy(() -> minValueInArray.minValue(new int[0]))
                .isInstanceOf(CanNotFindMinValueException.class)
                .hasMessage("Null or empty input array !");
    }
}
