package exercise.island;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IslandsDetectorTest {
    private final IslandsDetector islandsDetector = new IslandsDetector();

    @Test
    void nullMapArray() {
        assertThatThrownBy(() -> islandsDetector.getIslandsNumber(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Map can not be empty or null !");
    }

    @Test
    void emptyMapArray() {
        assertThatThrownBy(() -> islandsDetector.getIslandsNumber(new char[0][0]))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Map can not be empty or null !");
    }

    @Test
    void nullRowArray() {
        assertThatThrownBy(() -> islandsDetector.getIslandsNumber(new char[1][]))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Map row can not be empty or null !");
    }

    @Test
    void emptyRowArray() {
        final char[][] mapWithEmptyRow = new char[1][];
        mapWithEmptyRow[0] = new char[0];
        assertThatThrownBy(() -> islandsDetector.getIslandsNumber(mapWithEmptyRow))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Map row can not be empty or null !");
    }

    @Test
    void onlyWaterMap() {
        final char[][] map = new char[3][];
        map[0] = new char[]{'w', 'w', 'w'};
        map[1] = new char[]{'w', 'w', 'w'};
        map[2] = new char[]{'w', 'w', 'w'};

        assertThat(islandsDetector.getIslandsNumber(map)).isEqualTo(0);
    }
}
