package exercise.watertrap;

import org.apache.commons.lang3.ArrayUtils;

class WaterTrap {
    int getWaterTrapsNumber(final int[] array) {
        if (ArrayUtils.isEmpty(array)) {
            throw new IllegalArgumentException("Array can not be null or empty!");
        }

        final int maxLevel = getMaxLevel(array);
        int trapNumber = 0;
        for (int level = maxLevel; level > 0; level--) {
            final int firstHillIndex = getFirstHillIndex(array, level);
            final int lastHillIndex = getLastHillIndex(array, level);

            System.out.println("================> Level " + level);
            System.out.println("firstHillIndex " + firstHillIndex);
            System.out.println("lastHillIndex " + lastHillIndex);

            if (firstHillIndex != lastHillIndex) {
                for (int index = firstHillIndex; index <= lastHillIndex; index++) {
                    if (array[index] < level) {
                        trapNumber++;
                    }
                }
            }
        }

        return trapNumber;
    }

    private int getMaxLevel(final int[] array) {
        int max = Integer.MIN_VALUE;
        for (int element : array) {
            if (element > max) {
                max = element;
            }
        }

        return max;
    }

    private int getFirstHillIndex(final int[] array, final int level) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] >= level) {
                return index;
            }
        }
        return -1;
    }

    private int getLastHillIndex(final int[] array, final int level) {
        for (int index = array.length - 1; index >= 0; index--) {
            if (array[index] >= level) {
                return index;
            }
        }
        return -1;
    }
}
