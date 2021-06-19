package exercise.intarray.secondminvalue;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Optional;

class SecondMinValueFinder {
    Optional<Integer> findSecondMinValue(final int[] array) {
        if (ArrayUtils.isEmpty(array) || array.length < 2 || areAllElementsTheSame(array)) {
            return Optional.empty();
        }

        int minElement = array[0];
        Integer secondMinElement = null;

        for (int element : array) {
            if (element < minElement) {
                secondMinElement = minElement;
                minElement = element;
            } else if (secondMinElement == null && element != minElement) {
                secondMinElement = element;
            } else if (secondMinElement != null && element < secondMinElement && element != minElement) {
                secondMinElement = element;
            }
        }

        if (secondMinElement == null) {
            return Optional.empty();
        } else {
            return Optional.of(secondMinElement);
        }
    }

    private boolean areAllElementsTheSame(final int[] array) {
        final int firstElement = array[0];
        for(int element : array) {
            if (element != firstElement) {
                return false;
            }
        }

        return true;
    }
}
