package exercise.intarray.median.twosorted;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MedianTwoSortedArrayFinderTest {
    private final MedianTwoSortedArrayFinder medianTwoSortedArrayFinder = new MedianTwoSortedArrayFinder();

    @Test
    void nullArrays() {
        final Optional<Double> median = medianTwoSortedArrayFinder.getMedian(null, null);

        assertThat(median).isEmpty();
    }

    @Test
    void firstNullSecondEmpty() {
        final Optional<Double> median = medianTwoSortedArrayFinder.getMedian(null, new int[0]);

        assertThat(median).isEmpty();
    }

    @Test
    void firstEmptySecondNull() {
        final Optional<Double> median = medianTwoSortedArrayFinder.getMedian(new int[0], null);

        assertThat(median).isEmpty();
    }

    @Test
    void emptyArrays() {
        final Optional<Double> median = medianTwoSortedArrayFinder.getMedian(new int[0], new int[0]);

        assertThat(median).isEmpty();
    }

    @Test
    void first1ElementSecondEmpty() {
        final Optional<Double> median = medianTwoSortedArrayFinder.getMedian(new int[]{1}, new int[0]);

        assertThat(median)
                .isPresent()
                .hasValue(1d);
    }

    @Test
    void firstEmptySecond1Element() {
        final Optional<Double> median = medianTwoSortedArrayFinder.getMedian(new int[0], new int[]{1});

        assertThat(median)
                .isPresent()
                .hasValue(1d);
    }

    @Test
    void first2ElementsSecondEmpty() {
        final Optional<Double> median = medianTwoSortedArrayFinder.getMedian(new int[]{1, 2}, new int[0]);

        assertThat(median)
                .isPresent()
                .hasValue(1.5d);
    }

    @Test
    void firstEmptySecond2Elements() {
        final Optional<Double> median = medianTwoSortedArrayFinder.getMedian(new int[0], new int[]{1, 2});

        assertThat(median)
                .isPresent()
                .hasValue(1.5d);
    }

    @Test
    void first3ElementsSecondEmpty() {
        final Optional<Double> median = medianTwoSortedArrayFinder.getMedian(new int[]{1, 2, 3}, new int[0]);

        assertThat(median)
                .isPresent()
                .hasValue(2d);
    }

    @Test
    void firstEmptySecond3Elements() {
        final Optional<Double> median = medianTwoSortedArrayFinder.getMedian(new int[0], new int[]{1, 2, 3});

        assertThat(median)
                .isPresent()
                .hasValue(2d);
    }

    @Test
    void first3ElementsSecond5Elements() {
        final Optional<Double> median = medianTwoSortedArrayFinder.getMedian(new int[]{100, 200, 300}, new int[]{1, 2, 3, 4, 5});

        assertThat(median)
                .isPresent()
                .hasValue(4.5d);
    }

    @Test
    void first5ElementsSecond3Elements() {
        final Optional<Double> median = medianTwoSortedArrayFinder.getMedian(new int[]{1, 2, 3, 4, 5}, new int[]{100, 200, 300});

        assertThat(median)
                .isPresent()
                .hasValue(4.5d);
    }

    @Test
    void first3ElementsSecond6Elements() {
        final Optional<Double> median = medianTwoSortedArrayFinder.getMedian(new int[]{1, 3, 7}, new int[]{2, 4, 5, 6, 8, 9});

        assertThat(median)
                .isPresent()
                .hasValue(5d);
    }

    @Test
    void first5ElementsSecond6Elements() {
        final Optional<Double> median = medianTwoSortedArrayFinder.getMedian(new int[]{2, 4, 5, 6, 8, 9}, new int[]{1, 3, 7});

        assertThat(median)
                .isPresent()
                .hasValue(5d);
    }

}
