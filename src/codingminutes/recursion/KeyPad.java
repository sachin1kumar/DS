package codingminutes.recursion;

public class KeyPad {

    public static void main(String[] args) {
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //printKeyPadCombination("", "23", 0, letters);
        printKeyPadCombination("", "32", 0, letters);

    }

    private static void printKeyPadCombination(String output, String input, int index, String[] letters) {
        if (index == input.length()) {
            System.out.println(output);
            return;
        }

        if (input.charAt(index) == '0' || input.charAt(index) == '1') {
            printKeyPadCombination(output, input, index + 1, letters);
        }

        String letter = letters[input.charAt(index) - '0'];
        int len = letter.length();

        for (int index_ = 0; index_ < len; index_++) {
            printKeyPadCombination(output + letter.charAt(index_), input, index + 1, letters);
        }
    }
}
