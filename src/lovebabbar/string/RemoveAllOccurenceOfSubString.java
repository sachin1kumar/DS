package lovebabbar.string;

public class RemoveAllOccurenceOfSubString {

    public static void main(String[] args) {
       // System.out.print(removeOccurrences("daabcbaabcbc", "abc")); //dab
        System.out.print(removeOccurrences("axxxxyyyyb", "xy")); //ab

    }

    private static String removeOccurrences(String s, String part) {
        StringBuilder stringBuilder = new StringBuilder("");

        for (int index = 0; index < s.length(); index++) {
            stringBuilder.append(s.charAt(index));
            if (stringBuilder.toString().contains(part)) {
                int startIndex = stringBuilder.indexOf(part);
                stringBuilder.delete(startIndex, startIndex + part.length());
            }
        }
        return stringBuilder.toString();
    }
}
