package codingminutes;

public class MaxSubArraySum {

    public static void main(String[] args) {
        final int[] input = {-1, 2, 3, 4, -2, 6, -8, 3};
        System.out.println(getMaxSubArraySum(input));
    }

    private static int getMaxSubArraySum(int[] input) {
        int first = input[0];
        int sum = input[0];

        for (int index = 1; index < input.length; index++) {
            first = Math.max(input[index], input[index] + first);
            sum = Math.max(first, sum);
        }
        return sum;
    }
}
