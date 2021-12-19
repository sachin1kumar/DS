package codingminutes.string;

public class Space20Problem {

    public static void main(String[] args) {
            System.out.println(modifyString("hello world,  how are you?  "));
    }

    /*
    * Time complexity - O(N)
    * Space complexity - O(N)
    * */
    private static String modifyString(String input) {
        final StringBuilder stringBuilder = new StringBuilder(input);

        for (int index = 0; index < stringBuilder.length();) {
            if (stringBuilder.charAt(index) == ' ') {
                stringBuilder.replace(index, index + 1, "%20");
                index = index + 3;
            } else {
                index++;
            }
        }
        return stringBuilder.toString();
    }
}
