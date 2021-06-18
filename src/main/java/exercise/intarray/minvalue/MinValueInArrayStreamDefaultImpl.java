package exercise.intarray.minvalue;

import java.util.Arrays;
import java.util.OptionalInt;

class MinValueInArrayStreamDefaultImpl implements MinValueInArray {
    @Override
    public int minValue(final int[] array) {
        final OptionalInt minValue = Arrays.stream(array).min();

        if (minValue.isPresent()) {
            return minValue.getAsInt();
        } else {
            throw new CanNotFindMinValueException("Can not find min in IntStream !");
        }
    }
}
