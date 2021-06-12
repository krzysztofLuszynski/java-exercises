package exercise.minvalue;

import org.apache.commons.lang3.ArrayUtils;

class MinValueInArray {
    int minValue(final int[] array) {
        if (ArrayUtils.isEmpty(array)) {
            throw new IllegalArgumentException("Null or empty input array");
        } else {
            return 0;
        }
    }
}
