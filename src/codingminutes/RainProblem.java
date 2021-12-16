package codingminutes;

public class RainProblem {
    public static void main(String[] args) {
        //these are heights
        int[] input = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(getMaxWaterCapacity(input));
    }

    /*
    * Time complexity - O(N)
    * Space complexity- O(N)
    * */
    private static int getMaxWaterCapacity(int[] input) {
        int length = input.length;

        if (length <= 2) {
            return 0;
        }

        int[] left = new int[length];
        int[] right = new int[length];

        //fill left and right with max values.
        //for right fill it from the end of the input array.
        int leftMax = 0;
        for (int index = 0; index < length; index++) {
            leftMax = Math.max(leftMax, input[index]);
            left[index] = leftMax;
        }
        int rightMax = 0;
        for (int index = length - 1; index >= 0; index--) {
            rightMax = Math.max(rightMax, input[index]);
            right[index] = rightMax;
        }

        //Iterate input arr and calculate capacity with the logic:
        //min(left[i], right[i]) - input[i]
        int capacity = 0;
        for (int i = 0; i < length; i++) {
            capacity += (Math.min(left[i], right[i]) - input[i]);
        }
        return capacity;
    }
}
