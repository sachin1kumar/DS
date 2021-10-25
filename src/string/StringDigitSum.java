package string;

public class StringDigitSum {

    public static void main(String[] args) {
        String s = "ab8e37f23";

        int sum = 0;
        for (int i = 0; i < s.length();) {
            StringBuilder stringBuilder = new StringBuilder("");
            int j = i;
            while(j < s.length() && Character.isDigit(s.charAt(j))) {
                stringBuilder.append(""+s.charAt(j));
                j++;
            }

            if (stringBuilder.length() > 0) {
                int num = Integer.parseInt(stringBuilder.toString());
                sum += num;
                i = i + stringBuilder.length();
            } else {
                i++;
            }
        }
        System.out.println(sum);
    }
}
