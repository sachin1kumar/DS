package codingminutes.slidingwindow;

public class HousingProblem {

    public static void main(String[] args) {
        final int[] input = {1, 3, 2, 1, 4, 1, 3, 2, 1, 1, 2};
        printSubArrayIndex(input, 8);
    }

    /*
    * Time complexity - O(N)
    * */
    private static void printSubArrayIndex(int[] input, int k){
        int i = 0;
        int j = 0;

        int currentSum = 0;
        int length = input.length;

        while (j < length) {
            currentSum += input[j];
            j++;

            while (currentSum > k && i < j) {
                currentSum -= input[i];
                i++;
            }

            if (currentSum == k) {
                System.out.println(i+" "+(j-1));
            }
        }
    }
}
