package codingminutes.hashing;

public class CheckAnagramStrings {

    public static void main(String[] args) {
        /*final String s1 = "abac";
        final String s2 = "aabc"; //true*/
        final String s1 = "abbc";
        final String s2 = "aabc"; //false
        System.out.println(isAnagram(s1, s2));
    }

    private static boolean isAnagram(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) {
            return false;
        }

        //maintain freq.
        int[] freq = new int[27];
        //iterate first string.
        for (int index = 0; index < len1; index++) {
            freq[s1.charAt(index)-'a']++;
        }
        //iterate second string.
        for (int index = 0; index < len2; index++) {
            freq[s2.charAt(index)-'a']--;
            if (freq[s2.charAt(index)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
