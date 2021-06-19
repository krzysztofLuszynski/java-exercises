package exercise.island;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IslandsDetectorTest {
    private final IslandsDetector islandsDetector = new IslandsDetector();

    @Test
    void nullMapArray() {
        assertThatThrownBy(() -> islandsDetector.getAllIslands(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Map can not be empty or null !");
    }

    @Test
    void emptyMapArray() {
        assertThatThrownBy(() -> islandsDetector.getAllIslands(new char[0][0]))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Map can not be empty or null !");
    }

    @Test
    void nullRowArray() {
        assertThatThrownBy(() -> islandsDetector.getAllIslands(new char[1][]))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Map row can not be empty or null !");
    }

    @Test
    void emptyRowArray() {
        final char[][] mapWithEmptyRow = new char[1][];
        mapWithEmptyRow[0] = new char[0];
        assertThatThrownBy(() -> islandsDetector.getAllIslands(mapWithEmptyRow))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Map row can not be empty or null !");
    }

    @Test
    void invalidCharacterArray() {
        final char[][] invalidCharacterMap = new char[1][];
        invalidCharacterMap[0] = new char[]{'x'};
        assertThatThrownBy(() -> islandsDetector.getAllIslands(invalidCharacterMap))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Map element[0][0] with value: x is not land or water !");
    }

    @Test
    void onlyWaterMap() {
        final char[][] map = new char[3][];
        map[0] = new char[]{ 'w', 'w', 'w'};
        map[1] = new char[]{ 'w', 'w', 'w'};
        map[2] = new char[]{ 'w', 'w', 'w'};

        assertThat(islandsDetector.getAllIslands(map)).hasSize(0);
    }

    @Test
    void onlyLandMap() {
        final char[][] map = new char[3][];
        map[0] = new char[]{ 'l', 'l', 'l'};
        map[1] = new char[]{ 'l', 'l', 'l'};
        map[2] = new char[]{ 'l', 'l', 'l'};

        final List<Collection<IslandsDetector.Position>> allIslands = islandsDetector.getAllIslands(map);

        assertThat(allIslands).hasSize(1);
        assertThat(allIslands.get(0))
                .containsOnly(
                        new IslandsDetector.Position(0, 0),
                        new IslandsDetector.Position(0, 1),
                        new IslandsDetector.Position(0, 2),
                        new IslandsDetector.Position(1, 0),
                        new IslandsDetector.Position(1, 1),
                        new IslandsDetector.Position(1, 2),
                        new IslandsDetector.Position(2, 0),
                        new IslandsDetector.Position(2, 1),
                        new IslandsDetector.Position(2, 2)
                );
    }

    @Test
    void singleIslandLeftUpMap() {
        final char[][] map = new char[3][];
        map[0] = new char[]{ 'l', 'w', 'w'};
        map[1] = new char[]{ 'w', 'w', 'w'};
        map[2] = new char[]{ 'w', 'w', 'w'};

        final List<Collection<IslandsDetector.Position>> allIslands = islandsDetector.getAllIslands(map);

        assertThat(allIslands).hasSize(1);
        assertThat(allIslands.get(0))
                .containsExactly(new IslandsDetector.Position(0, 0));
    }

    @Test
    void singleIslandRightUpMap() {
        final char[][] map = new char[3][];
        map[0] = new char[]{ 'w', 'w', 'l'};
        map[1] = new char[]{ 'w', 'w', 'w'};
        map[2] = new char[]{ 'w', 'w', 'w'};

        final List<Collection<IslandsDetector.Position>> allIslands = islandsDetector.getAllIslands(map);

        assertThat(allIslands).hasSize(1);
        assertThat(allIslands.get(0))
                .containsExactly(new IslandsDetector.Position(0, 2));
    }

    @Test
    void singleIslandCenterMap() {
        final char[][] map = new char[3][];
        map[0] = new char[]{ 'w', 'w', 'w'};
        map[1] = new char[]{ 'w', 'l', 'w'};
        map[2] = new char[]{ 'w', 'w', 'w'};

        final List<Collection<IslandsDetector.Position>> allIslands = islandsDetector.getAllIslands(map);

        assertThat(allIslands).hasSize(1);
        assertThat(allIslands.get(0))
                .containsExactly(new IslandsDetector.Position(1, 1));
    }

    @Test
    void singleIslandLeftDownMap() {
        final char[][] map = new char[3][];
        map[0] = new char[]{ 'w', 'w', 'w'};
        map[1] = new char[]{ 'w', 'w', 'w'};
        map[2] = new char[]{ 'l', 'w', 'w'};

        final List<Collection<IslandsDetector.Position>> allIslands = islandsDetector.getAllIslands(map);

        assertThat(allIslands).hasSize(1);
        assertThat(allIslands.get(0))
                .containsExactly(new IslandsDetector.Position(2, 0));
    }

    @Test
    void singleIslandRightDownMap() {
        final char[][] map = new char[3][];
        map[0] = new char[]{ 'w', 'w', 'w'};
        map[1] = new char[]{ 'w', 'w', 'w'};
        map[2] = new char[]{ 'w', 'w', 'l'};

        final List<Collection<IslandsDetector.Position>> allIslands = islandsDetector.getAllIslands(map);

        assertThat(allIslands).hasSize(1);
        assertThat(allIslands.get(0))
                .containsExactly(new IslandsDetector.Position(2, 2));
    }

    @Test
    void threeIslandsMap() {
        final char[][] map = new char[3][];
        map[0] = new char[]{ 'l', 'w', 'w'};
        map[1] = new char[]{ 'w', 'l', 'w'};
        map[2] = new char[]{ 'w', 'w', 'l'};

        final List<Collection<IslandsDetector.Position>> allIslands = islandsDetector.getAllIslands(map);

        assertThat(allIslands).hasSize(3);
        assertThat(allIslands.get(0)).containsOnly(new IslandsDetector.Position(0, 0));
        assertThat(allIslands.get(1)).containsOnly(new IslandsDetector.Position(1, 1));
        assertThat(allIslands.get(2)).containsOnly(new IslandsDetector.Position(2, 2));
    }

    @Test
    void twoIslandsMap() {
        final char[][] map = new char[3][];
        map[0] = new char[]{ 'l', 'l', 'w'};
        map[1] = new char[]{ 'l', 'w', 'l'};
        map[2] = new char[]{ 'w', 'w', 'l'};

        final List<Collection<IslandsDetector.Position>> allIslands = islandsDetector.getAllIslands(map);

        assertThat(allIslands).hasSize(2);
        assertThat(allIslands.get(0)).containsOnly(
                new IslandsDetector.Position(0, 0),
                new IslandsDetector.Position(1, 0),
                new IslandsDetector.Position(0, 1));

        assertThat(allIslands.get(1)).containsOnly(
                new IslandsDetector.Position(1, 2),
                new IslandsDetector.Position(2, 2));
    }

    @Test
    void twoIslands1Map() {
        final char[][] map = new char[5][];
        map[0] = new char[]{ 'l', 'l', 'l', 'l', 'l'};
        map[1] = new char[]{ 'l', 'w', 'w', 'w', 'l'};
        map[2] = new char[]{ 'l', 'w', 'l', 'w', 'l'};
        map[3] = new char[]{ 'l', 'w', 'w', 'w', 'l'};
        map[4] = new char[]{ 'l', 'l', 'l', 'l', 'l'};

        final List<Collection<IslandsDetector.Position>> allIslands = islandsDetector.getAllIslands(map);

        assertThat(allIslands).hasSize(2);
        assertThat(allIslands.get(0)).containsOnly(
                new IslandsDetector.Position(0, 0),
                new IslandsDetector.Position(0, 1),
                new IslandsDetector.Position(0, 2),
                new IslandsDetector.Position(0, 3),
                new IslandsDetector.Position(0, 4),

                new IslandsDetector.Position(1, 0),
                new IslandsDetector.Position(1, 4),

                new IslandsDetector.Position(2, 0),
                new IslandsDetector.Position(2, 4),

                new IslandsDetector.Position(3, 0),
                new IslandsDetector.Position(3, 4),

                new IslandsDetector.Position(4, 0),
                new IslandsDetector.Position(4, 1),
                new IslandsDetector.Position(4, 2),
                new IslandsDetector.Position(4, 3),
                new IslandsDetector.Position(4, 4)
                );

        assertThat(allIslands.get(1)).containsOnly(
                new IslandsDetector.Position(2, 2));
    }
}
