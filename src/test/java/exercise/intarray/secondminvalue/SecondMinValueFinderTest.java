package exercise.intarray.secondminvalue;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class SecondMinValueFinderTest {
    private final SecondMinValueFinder secondMinValueFinder = new SecondMinValueFinder();

    @Test
    void nullArray() {
        final Optional<Integer> secondMinValue = secondMinValueFinder.findSecondMinValue(null);

        assertThat(secondMinValue).isEmpty();
    }

    @Test
    void emptyArray() {
        final Optional<Integer> secondMinValue = secondMinValueFinder.findSecondMinValue(new int[0]);

        assertThat(secondMinValue).isEmpty();
    }

    @Test
    void arrayOneElement() {
        final Optional<Integer> secondMinValue = secondMinValueFinder.findSecondMinValue(new int[]{1});

        assertThat(secondMinValue).isEmpty();
    }

    @Test
    void arrayAllElementsTheSame() {
        final Optional<Integer> secondMinValue = secondMinValueFinder.findSecondMinValue(new int[]{1,1,1,1,1,1});

        assertThat(secondMinValue).isEmpty();
    }

    @Test
    void arrayTwoElements() {
        final Optional<Integer> secondMinValue = secondMinValueFinder.findSecondMinValue(new int[]{1,2});

        assertThat(secondMinValue).isPresent().hasValue(2);
    }

    @Test
    void arrayTwoElements1() {
        final Optional<Integer> secondMinValue = secondMinValueFinder.findSecondMinValue(new int[]{2,1});

        assertThat(secondMinValue).isPresent().hasValue(2);
    }

    @Test
    void arrayFiveElements() {
        final Optional<Integer> secondMinValue = secondMinValueFinder.findSecondMinValue(new int[]{ 2, 1, 100, -200, 2});

        assertThat(secondMinValue).isPresent().hasValue(1);
    }

    @Test
    void arrayFiveElements1() {
        final Optional<Integer> secondMinValue = secondMinValueFinder.findSecondMinValue(new int[]{ -200, 2, 1, 100, -200});

        assertThat(secondMinValue).isPresent().hasValue(1);
    }

    @Test
    void arrayFiveElements2() {
        final Optional<Integer> secondMinValue = secondMinValueFinder.findSecondMinValue(new int[]{ -200, 2, 100, -200, 1});

        assertThat(secondMinValue).isPresent().hasValue(1);
    }

}
