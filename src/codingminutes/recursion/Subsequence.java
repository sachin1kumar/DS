package codingminutes.recursion;

public class Subsequence {

    public static void main(String[] args) {
        printSubsequence("abc", 0, "");
    }

    private static void printSubsequence(String input, int index, String output) {
        if (index == input.length()) {
            System.out.println(output);
            return;
        }

        printSubsequence(input, index + 1, output);

        output = output + input.charAt(index);
        printSubsequence(input, index + 1, output);
    }
}
