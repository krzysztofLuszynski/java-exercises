package exercise.intarray.cycle;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

class CycleDetector {
    List<List<Integer>> getCycles(final int[] array) {
        if (ArrayUtils.isEmpty(array)) {
            return Collections.emptyList();
        }

        final List<List<Integer>> cycles = new ArrayList<>();

        final List<Integer> processed = new ArrayList<>();
        List<Integer> currentCycle = new ArrayList<>();
        int currentIndex = 0;
        while (processed.size() != array.length) {
            if (currentCycle.isEmpty()) {
                final Optional<Integer> index = findFirstNotProcessedIndex(array, processed);
                if (!index.isPresent()) {
                    break;
                }

                currentIndex = index.get();
            }

            processed.add(currentIndex);
            currentCycle.add(currentIndex);

            final int nextIndex = array[currentIndex];
            if (currentCycle.contains(nextIndex)) {
                final List<Integer> cycle =  currentCycle.subList(currentCycle.indexOf(nextIndex), currentCycle.size());
                cycles.add(cycle);
                currentCycle = new ArrayList<>();
            } else if (nextIndex >= array.length || nextIndex < 0) {
                currentCycle = new ArrayList<>();
            } else if (processed.contains(nextIndex)) {
                currentCycle = new ArrayList<>();
            } else {
                currentIndex = nextIndex;
            }
        }

        return cycles;
    }

    private Optional<Integer> findFirstNotProcessedIndex(final int[] array, final List<Integer> processed) {
        for (int index = 0; index < array.length; index++) {
            if (!processed.contains(index)) {
                return Optional.of(index);
            }
        }

        return Optional.empty();
    }
}
