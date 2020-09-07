package dynamicprogramming;

public class StairCaseProb {

    public static void main(String[] args) {
        System.out.println(calcNoOfWays(4));
    }

    private static int calcNoOfWays(int steps) {
        int[] arr = new int[steps];
        arr[0] = 1;
        arr[1] = 1;

        int noOfWays = 2;

        for (int i = 2; i < steps; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
            noOfWays += arr[i];
        }

        return noOfWays;
    }
}
