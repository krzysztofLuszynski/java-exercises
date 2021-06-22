package exercise.watertrap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WaterTrapTest {
    private final WaterTrap waterTrap = new WaterTrap();

    @Test
    void nullArray() {
        assertThatThrownBy(() -> waterTrap.getWaterTrapsNumber(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Array can not be null or empty!");
    }

    @Test
    void emptyArray() {
        assertThatThrownBy(() -> waterTrap.getWaterTrapsNumber(new int[0]))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Array can not be null or empty!");
    }

    @Test
    void exampleArray() {
        final int trapNumber = waterTrap.getWaterTrapsNumber(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});

        assertThat(trapNumber).isEqualTo(6);
    }

    @Test
    void exampleArray1() {
        final int trapNumber = waterTrap.getWaterTrapsNumber(new int[]{4,0,0,0,0,4});

        assertThat(trapNumber).isEqualTo(16);
    }
}
