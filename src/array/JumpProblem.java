package array;

public class JumpProblem {

    public static void main(String[] args) {
        //int[] arr = {1, 1, 2, 5, 2, 1, 0, 0, 1, 3};
        int[] arr = {1, 2, 1, 0, 2};

        System.out.println(checkArray(arr));
    }

    private static boolean checkArray(int[] arr) {
        int reachable = 0;
        for (int i  = 0; i < arr.length; i++) {
            if (reachable < i) {
                return false;
            }
            reachable = Integer.max(reachable, i + arr[i]);
        }
        return true;
    }
}
