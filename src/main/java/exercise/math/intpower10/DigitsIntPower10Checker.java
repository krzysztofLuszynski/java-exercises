package exercise.math.intpower10;

import org.apache.commons.lang3.StringUtils;

class DigitsIntPower10Checker implements IntPower10Checker {
    @Override
    public boolean isPowerOf10(final int number) {
        final String string = "" + number;

        if (StringUtils.equals(string, "0")) {
            return true;
        } else {
            if (string.charAt(0) != '1') {
                return false;
            }

            for (char character : string.substring(1).toCharArray()) {
                if (character != '0') {
                    return false;
                }
            }

            return true;
        }
    }
}
