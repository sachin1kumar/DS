package backtracking;

public class SubsetSum {

    public static void main(String[] args) {
        int[] arr = {5, 12, 3, 17, 1, 18, 15, 3, 17};
        int sum = 6;
        isSubsetSum(arr, arr.length, sum);
    }

    private static void isSubsetSum(int[] arr, int n, int sum) {
        //base cases..
        if(sum == 0) {
            System.out.println(arr[n] +", "+ arr[n + 1]);
            return;
        }
        //size of array is zero..
        if (n == 0 && sum != 0) {
            return;
        }

        //skip the last element and exclude it..
        if (arr[n - 1] > sum) {
            isSubsetSum(arr, n - 1, sum);
        }

        isSubsetSum(arr, n - 1, sum);
        isSubsetSum(arr, n - 1, sum - arr[n -1]);
    }

}

