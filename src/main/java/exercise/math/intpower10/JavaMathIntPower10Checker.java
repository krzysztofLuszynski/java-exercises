package exercise.math.intpower10;

class JavaMathIntPower10Checker implements IntPower10Checker {
    @Override
    public boolean isPowerOf10(final int number) {
        double log = Math.log10(number);
        return log == Math.floor(log) && !Double.isInfinite(log);
    }
}
