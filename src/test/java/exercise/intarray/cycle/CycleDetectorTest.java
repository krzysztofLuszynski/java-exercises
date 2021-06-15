package exercise.intarray.cycle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CycleDetectorTest {
    private final CycleDetector cycleDetector = new CycleDetector();

    @Test
    void nullArray() {
        final List<List<Integer>> cycles = cycleDetector.getCycles(null);

        assertThat(cycles).isEmpty();
    }

    @Test
    void emptyArray() {
        final List<List<Integer>> cycles = cycleDetector.getCycles(new int[0]);

        assertThat(cycles).isEmpty();
    }

    @Test
    void oneElementNoCycle() {
        final List<List<Integer>> cycles = cycleDetector.getCycles(new int[]{12});

        assertThat(cycles).isEmpty();
    }

    @Test
    void fiveElementsNoCycle() {
        final List<List<Integer>> cycles = cycleDetector.getCycles(new int[]{12, 44, 20, 10, 1});

        assertThat(cycles).isEmpty();
    }

    @Test
    void fiveElementsNoCycle1() {
        final List<List<Integer>> cycles = cycleDetector.getCycles(new int[]{1, 2, 3, 4, 6});

        assertThat(cycles).isEmpty();
    }

    @Test
    void oneElementArrayOneCycle() {
        final List<List<Integer>> cycles = cycleDetector.getCycles(new int[]{0});

        assertThat(cycles)
                .hasSize(1)
                .contains(Collections.singletonList(0));
    }

    @Test
    void fiveElementArrayOneCycle() {
        final List<List<Integer>> cycles = cycleDetector.getCycles(new int[]{1, 2, 0, 0, 0});

        assertThat(cycles)
                .hasSize(1)
                .contains(Arrays.asList(0, 1, 2));
    }

    @Test
    void fiveElementArrayOneCycle1() {
        final List<List<Integer>> cycles = cycleDetector.getCycles(new int[]{3, 2, 0, 4, 0});

        assertThat(cycles)
                .hasSize(1)
                .contains(Arrays.asList(0, 3, 4));
    }

    @Test
    void fiveElementArrayOneCycle2() {
        final List<List<Integer>> cycles = cycleDetector.getCycles(new int[]{3, 2, 0, 4, 1});

        assertThat(cycles)
                .hasSize(1)
                .contains(Arrays.asList(0, 3, 4, 1, 2));
    }

    @Test
    void fiveElementArrayOneCycle3() {
        final List<List<Integer>> cycles = cycleDetector.getCycles(new int[]{3, 4, 0, 4, 1});

        assertThat(cycles)
                .hasSize(1)
                .contains(Arrays.asList(4, 1));
    }

    @Test
    void sevenElementArrayOneCycle() {
        final List<List<Integer>> cycles = cycleDetector.getCycles(new int[]{3, 2, 0, 4, 1, 10, 20});

        assertThat(cycles)
                .hasSize(1)
                .contains(Arrays.asList(0, 3, 4, 1, 2));
    }

    @Test
    void sevenElementArrayOneCycle1() {
        final List<List<Integer>> cycles = cycleDetector.getCycles(new int[]{3, 2, 0, 4, 1, 0, 1});

        assertThat(cycles)
                .hasSize(1)
                .contains(Arrays.asList(0, 3, 4, 1, 2));
    }

    @Test
    void sevenElementArrayOneCycle3() {
        final List<List<Integer>> cycles = cycleDetector.getCycles(new int[]{1, 2, 3, 4, 5, 6, 4});

        assertThat(cycles)
                .hasSize(1)
                .contains(Arrays.asList(4, 5, 6));
    }

    @Test
    void sevenElementArrayTwoCycles() {
        final List<List<Integer>> cycles = cycleDetector.getCycles(new int[]{1, 2, 3, 4, 0, 6, 5});

        assertThat(cycles)
                .hasSize(2)
                .contains(Arrays.asList(0, 1, 2, 3, 4))
                .contains(Arrays.asList(5, 6));
    }

    @Test
    void tenElementArrayTwoCycles() {
        final List<List<Integer>> cycles = cycleDetector.getCycles(new int[]{1, 2, 3, 4, 0, 0, 0, 0, 9, 8});

        assertThat(cycles)
                .hasSize(2)
                .contains(Arrays.asList(0, 1, 2, 3, 4))
                .contains(Arrays.asList(8, 9));
    }

    @Test
    void tenElementArrayTwoCycles1() {
        final List<List<Integer>> cycles = cycleDetector.getCycles(new int[]{5, 6, 9, 2, 0, 3, 7, 8, 1, 4});

        assertThat(cycles)
                .hasSize(2)
                .contains(Arrays.asList(0, 5, 3, 2, 9, 4))
                .contains(Arrays.asList(1, 6, 7, 8));
    }

    @Test
    void twentyElementArrayTwoCycles() {
        final List<List<Integer>> cycles = cycleDetector.getCycles(new int[]{
                5, 6, 9, 2, 0, 3, 7, 8, 1, 4, 0, 0, 0, 0, 15, 16, 17, 18, 19, 14});

        assertThat(cycles)
                .hasSize(3)
                .contains(Arrays.asList(0, 5, 3, 2, 9, 4))
                .contains(Arrays.asList(1, 6, 7, 8))
                .contains(Arrays.asList(14, 15, 16, 17, 18, 19));
    }
}
