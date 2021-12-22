package codingminutes.slidingwindow;

public class SmallestDistinctWindow {

    public static void main(String[] args) {
        System.out.println(getDistinctString("aabcbcdbcaaad")); //dbca
        /*
        * a
        * aa   -> false
        * ab
        * abc
        * abcb -> false
        * bcbc -> false
        * cbcd -> false
        * bcdb -> false
        * cdbc -> false
        * dbca -- output ---
        * dbcaa -> false
        * bcaa -> false
        * caaa -> false
        * aaad -> false
        * */

        //System.out.println(getDistinctString("aaaa")); //a
        /*
        * a  --- output ---
        * aa -> false
        * aa -> false
        * aa -> false
        * */
    }

    /*
    * Time complexity - O(N) using sliding window approach
    * Space complexity - O(1)
    * */
    private static String getDistinctString(String input) {
        int length = input.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return input;
        }
        int maxLength = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int firstSubStringIndex = 0;
        int secondSubStringIndex = 0;

        while (j < length) {
            int size = (j - i) + 1;
            boolean isContainDuplicate = isContainDuplicate(input.substring(i, j + 1), size);
            while (i < length && j < length - 1 && isContainDuplicate) {
                i++;
                j++;
                isContainDuplicate = isContainDuplicate(input.substring(i, j + 1), size);
            }
            if (!isContainDuplicate && size > maxLength) {
                maxLength = size;
                firstSubStringIndex = i;
                secondSubStringIndex = j;
            }
            j++;
        }
        return input.substring(firstSubStringIndex, secondSubStringIndex + 1);
    }

    private static boolean isContainDuplicate(String str, int N) {
        boolean isDuplicate = false;
        // Check if (i + 'a') is present
        // in str at least once or not.
        int first = 0;
        // Check if (i + 'a') is present
        // in str at least twice or not.
        int second = 0;
        // Iterate over the characters
        // of the string str
        for (int i = 0; i < N; i++) {
            // If str[i] has already occurred in str
            if ((first & (1 << (str.charAt(i) - 'a'))) != 0) {
                // Set (str[i] - 'a')-th bit of second
                second = second | (1 << (str.charAt(i) - 'a'));
            } else {
                // Set (str[i] - 'a')-th bit of second
                first = first | (1 << (str.charAt(i) - 'a'));
            }
        }
        // Iterate over the range [0, 25]
        for (int i = 0; i < 26; i++) {
            // If i-th bit of both first
            // and second is Set
            if (((first & (1 << i)) & (second & (1 << i))) != 0) {
                //System.out.print((char) (i + 'a') + " ");
                isDuplicate = true;
            }
        }
        return isDuplicate;
    }
}
