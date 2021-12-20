package codingminutes.string;

public class PalindromeBreak {

    public static void main(String[] args) {
        System.out.println(breakPalindrome("aza"));
    }

    private static String breakPalindrome(String input) {
        int length = input.length();
        final StringBuilder stringBuilder = new StringBuilder(input);

        if (length == 0 || length == 1) {
            return "";
        }

        int firstChar = input.charAt(0);
        int secondChar = input.charAt(1);

        if (length == 3) {
            if (firstChar < secondChar) {
                stringBuilder.setCharAt(length - 1, input.charAt(1));
            } else if (firstChar > secondChar) {
                stringBuilder.setCharAt(0, input.charAt(1));
            } else {
                if (firstChar == 97) {
                    stringBuilder.setCharAt(length - 1, (char) (firstChar + 1));
                }
                if (firstChar == 122) {
                    stringBuilder.setCharAt(0, 'a');
                }

                if (firstChar > 97 && firstChar < 122) {
                    stringBuilder.setCharAt(0, 'a');
                }
            }
            return stringBuilder.toString();
        }

        if (firstChar > secondChar) {
            stringBuilder.setCharAt(0, (char) secondChar);
        } else if (firstChar < secondChar) {
            stringBuilder.setCharAt(1, (char) firstChar);
        } else {
            if (firstChar == 97) {
                stringBuilder.setCharAt(length - 1, (char) (firstChar + 1));
            }
            if (firstChar == 122) {
                stringBuilder.setCharAt(0, 'a');
            }

            if (firstChar > 97 && firstChar < 122) {
                stringBuilder.setCharAt(0, 'a');
            }
        }

        return stringBuilder.toString();
    }
}
