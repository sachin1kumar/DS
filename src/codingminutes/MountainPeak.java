package codingminutes;

public class MountainPeak {

    public static void main(String[] args) {
        int[] input = {5, 6, 1, 2, 3, 4, 5, 4, 3, 2, 0, 1, 2, 3, -2, 4};
        System.out.println(getPeak(input));
    }

    private static int getPeak(int[] input) {
        int length = input.length;

        if (length < 3) {
            return -1;
        }

        int peak = 0;

        for (int index = 1; index <= length - 2; index++) {
            if (input[index] > input[index - 1] && input[index] > input[index + 1]) {
                int count = 1;
                int i = index;
                int j = index;
                while (i > 1 && input[i] > input[i - 1]) {
                    count++;
                    i--;
                }
                while (j < length - 1 && input[j] > input[j + 1]) {
                    count++;
                    j++;
                }
                peak = Math.max(peak, count);
            }
        }
        return peak;
    }
}
