package exercise.intarray.median.twosorted;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Optional;

class MedianTwoSortedArrayFinder {
     Optional<Double> getMedian(final int[] first, final int[] second) {
         if (ArrayUtils.isEmpty(first) && ArrayUtils.isEmpty(second)) {
             return Optional.empty();
         }

         final int[] mergedArray = getMergedArray(first, second);

         final double median;
         if (mergedArray.length == 1) {
             median = mergedArray[0];
         } else if (mergedArray.length % 2 == 0) {
             final double firstElement = mergedArray[mergedArray.length / 2];
             final double secondElement = mergedArray[mergedArray.length / 2] - 1;
             median = (firstElement + secondElement) / 2;
         } else {
             median = mergedArray[mergedArray.length / 2];
         }

         return Optional.of(median);
     }

     private int[] getMergedArray(final int[] first, final int[] second) {
         if (ArrayUtils.isEmpty(first)) {
             return second;
         } else if (ArrayUtils.isEmpty(second)) {
             return first;
         } else {
             final int[] mergedArray = new int[first.length + second.length];

             int firstIndex = 0;
             int secondIndex = 0;
             do {
                 if (firstIndex == first.length) {
                     if (secondIndex < second.length) {
                         mergedArray[firstIndex + secondIndex] = second[secondIndex];
                         secondIndex++;
                     }
                 } else if (secondIndex == second.length) {
                     if (firstIndex < first.length) {
                         mergedArray[firstIndex + secondIndex] = first[firstIndex];
                         firstIndex++;
                     }
                 } else if (first[firstIndex] > second[secondIndex]) {
                     mergedArray[firstIndex + secondIndex] = second[secondIndex];
                     secondIndex++;
                 } else {
                     mergedArray[firstIndex + secondIndex] = first[firstIndex];
                     firstIndex++;
                 }
             } while ((firstIndex + secondIndex) < mergedArray.length);

             return mergedArray;
         }
     }
}
