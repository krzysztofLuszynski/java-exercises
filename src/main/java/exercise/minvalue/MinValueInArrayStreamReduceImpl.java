package exercise.minvalue;

import java.util.Arrays;
import java.util.OptionalInt;

class MinValueInArrayStreamReduceImpl implements MinValueInArray {
    @Override
    public int minValue(final int[] array) {
        final OptionalInt minValue = Arrays.stream(array).
                reduce((first, second) -> {
                    if (first < second) {
                        return first;
                    } else {
                        return second;
                    }
                });

        if (minValue.isPresent()) {
            return minValue.getAsInt();
        } else {
            throw new CanNotFindMinValueException("Can not find min in IntStream");
        }
    }
}
