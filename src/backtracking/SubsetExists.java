package backtracking;

public class SubsetExists {

    public static void main(String[] args) {
        //int[] arr = {1, 2, 3};
        int[] arr = {5, 12, 3, 17, 1, 18, 15, 3, 17};
        int sum = 6;
        System.out.println(isSubsetSum(arr, arr.length, sum));
    }

    private static boolean isSubsetSum(int[] arr, int n, int sum) {
        //base cases..
        if(sum == 0) {
            return true;
        }
        //size of array is zero..
        if (n == 0 && sum != 0) {
            return false;
        }

        //skip the last element and exclude it..
        if (arr[n - 1] > sum) {
            return isSubsetSum(arr, n - 1, sum);
        }

        return isSubsetSum(arr, n - 1, sum) || isSubsetSum(arr, n - 1, sum - arr[n -1]);
    }

}
