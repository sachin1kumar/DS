package recursion;

public class Exponential {
    public static void main(String[] args) {
        System.out.println(getExponential(5));
    }

    private static int getExponential(int power) {
        if (power == 0) {
            return 1;
        }

        if (power % 2 != 0) {
            return 2 * getExponential(power/2) * getExponential(power/2);
        } else {
            return getExponential(power/2) * getExponential(power/2);
        }
    }
}
