package lovebabbar.recursion;

public class RecursionTest {

    public static void main(String[] args) {
        int[] arr = {2, 4, 9, 9, 9};
        System.out.println(getSum(arr, arr.length));
        System.out.println(isPresent(arr, arr.length, 4));
    }

    private static int getSum(int[] arr, int size) {
        if (size <= 0) {
            return 0;
        }
        return arr[size - 1] + getSum(arr, size - 1);
    }

    private static boolean isPresent(int[] arr, int size, int target) {
        if (size == 0) {
            return false;
        }
        if (arr[size - 1] == target) {
            return true;
        }
        return isPresent(arr, size - 1, target);
    }
}
