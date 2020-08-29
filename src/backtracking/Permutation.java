package backtracking;

public class Permutation {

    public static void main(String[] args) {
        StringBuilder input = new StringBuilder("ABC");
        printPermutation(input, 0, input.length() - 1);
    }

    private static void printPermutation(StringBuilder input, int startIndex, int lastIndex) {
        if(startIndex == lastIndex) {
            System.out.println(input);
            return;
        }

        for (int i = startIndex; i <= lastIndex; i++) {
            //swap the char..
            swap(input, i, startIndex);

            printPermutation(input, startIndex + 1, lastIndex);

            //reset the char...we call it backtracking
            swap(input, i, startIndex);
        }
    }

    private static void swap(StringBuilder input, int i, int startIndex) {
        char firstChar = input.charAt(startIndex);
        char secondChar = input.charAt(i);
        input.setCharAt(startIndex, secondChar);
        input.setCharAt(i, firstChar);
    }
}
