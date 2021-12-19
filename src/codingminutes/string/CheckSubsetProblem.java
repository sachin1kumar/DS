package codingminutes.string;

public class CheckSubsetProblem {

    public static void main(String[] args) {
        System.out.println(isSubset("coding minutes", "cines"));
    }

    /*
    * Time complexity - O(M + N) = O(N)
    * Space complexity - O(1)
    * */
    private static boolean isSubset(String input, String subset) {
        if (input.length() == 0 || subset.length() == 0) {
            return false;
        }

        int firstPointer = input.length() - 1;
        int secondPointer = subset.length() - 1;

        while (firstPointer != -1) {
            if (input.charAt(firstPointer) == subset.charAt(secondPointer)) {
                secondPointer--;
            }

            if (secondPointer == -1) {
                return true;
            }
            firstPointer--;
        }
        return false;
    }
}
