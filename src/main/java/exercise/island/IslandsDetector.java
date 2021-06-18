package exercise.island;

import org.apache.commons.lang3.ArrayUtils;

class IslandsDetector {
    int getIslandsNumber(final char[][] map) {
        assertConditions(map);

        return 0;
    }

    private void assertConditions(final char[][] map) {
        if (ArrayUtils.isEmpty(map)) {
            throw new IllegalArgumentException("Map can not be empty or null !");
        }

        for (int rowIndex = 0 ; rowIndex < map.length; rowIndex++) {
            if (ArrayUtils.isEmpty(map[rowIndex])) {
                throw new IllegalArgumentException("Map row can not be empty or null !");
            }
        }
    }
}
