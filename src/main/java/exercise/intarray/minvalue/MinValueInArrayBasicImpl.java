package exercise.intarray.minvalue;

import org.apache.commons.lang3.ArrayUtils;

class MinValueInArrayBasicImpl implements MinValueInArray {
    @Override
    public int minValue(final int[] array) {
        if (ArrayUtils.isEmpty(array)) {
            throw new CanNotFindMinValueException("Null or empty input array");
        } else if (array.length == 1) {
            return array[0];
        } else {
            int minValue = array[0];

            for (int element : array) {
               if (element < minValue) {
                   minValue = element;
               }
            }

            return minValue;
        }
    }
}
