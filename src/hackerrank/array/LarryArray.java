package hackerrank.array;

public class LarryArray {

    public static void main(String[] args) {
        int[] arr = {1, 6, 5, 2, 4, 3};
        System.out.println(larrysArray(arr));
    }

    private static String larrysArray(int[] A) {
        int inv = 0;

        for(int i = 0; i < A.length; i++) {
            for(int j = i + 1; j < A.length; j++) {
                if(A[i] > A[j]){
                    inv++;
                }
            }
        }

        if(inv % 2 == 0) {
            return "YES";
        }
        return "NO";
    }

}
