package lovebabbar;

public class PalindromCheck {

    public static void main(String[] args) {
        System.out.print(checkPalindrome("N2 i&nJA?a& jnI2n"));
    }

    public static boolean checkPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        while (i <= j) {
            char firstCh = str.charAt(i);
            char secondCh = str.charAt(j);

            while (!((firstCh >= 'a' && firstCh <= 'z') ||
                    (firstCh >= 'A' && firstCh <= 'Z') ||
                    (firstCh >= '0' && firstCh <= '9'))
            ) {
                i++;
                if (i < str.length())
                    firstCh = str.charAt(i);
                else
                    break;
            }

            while (!((secondCh >= 'a' && secondCh <= 'z') ||
                    (secondCh >= 'A' && secondCh <= 'Z') ||
                    (secondCh >= '0' && secondCh <= '9'))
            ) {
                j--;
                if (j >= 0)
                    secondCh = str.charAt(j);
                else
                    break;
            }

            if (toLowerCase(firstCh) != toLowerCase(secondCh)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    private static char toLowerCase(char ch) {
        if ((ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9')) {
            return ch;
        }
        return (char) ((ch - 'A') + 'a');
    }
}
