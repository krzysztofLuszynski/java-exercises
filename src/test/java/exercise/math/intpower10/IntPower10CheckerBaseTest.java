package exercise.math.intpower10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

abstract class IntPower10CheckerBaseTest {
    private final IntPower10Checker intPower10Checker;

    IntPower10CheckerBaseTest(final IntPower10Checker intPower10Checker) {
        this.intPower10Checker = intPower10Checker;
    }

    @Test
    void test1() {
        assertThat(intPower10Checker.isPowerOf10(1)).isTrue();
    }

    @Test
    void test2() {
        assertThat(intPower10Checker.isPowerOf10(2)).isFalse();
    }

    @Test
    void test10() {
        assertThat(intPower10Checker.isPowerOf10(10)).isTrue();
    }

    @Test
    void testMinus10() {
        assertThat(intPower10Checker.isPowerOf10(-10)).isFalse();
    }

    @Test
    void test255() {
        assertThat(intPower10Checker.isPowerOf10(255)).isFalse();
    }

    @Test
    void test1000() {
        assertThat(intPower10Checker.isPowerOf10(1000)).isTrue();
    }
}
