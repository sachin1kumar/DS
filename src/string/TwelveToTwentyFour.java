package string;

public class TwelveToTwentyFour {
    public static void main(String[] args) {
        String s = "11:59:00AM";
        System.out.println(timeConversion(s));
    }

    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        int hr = getHr(s);
        StringBuilder builder = new StringBuilder("");

        if(s.contains("AM") && hr < 12){
            int index = 0;
            if(isSingleDigit(hr)){
                builder.append('0');
                builder.append(hr);
                index = 2;
            } else{
                index = 0;
            }

            for(int i = index; i < 8; i++){
                builder.append(s.charAt(i));
            }
        } else if(hr == 12 && s.contains("AM")){
            builder.append('0');
            builder.append('0');

            for(int i = 2; i < 8; i++){
                builder.append(s.charAt(i));
            }
        } else if(s.contains("PM") && hr < 12){
            hr = hr + 12;
            builder.append(hr+"");
            for(int i = 2; i < 8; i++){
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

    private static int getHr(String s){
        StringBuilder builder = new StringBuilder("");
        if(s.charAt(0) != '0'){
            builder.append(s.charAt(0));
        }
        builder.append(s.charAt(1));
        String str = builder.toString();
        return Integer.parseInt(str);
    }

    private static boolean isSingleDigit(int hr){
        String str = hr+"";
        if(str.length() == 1){
            return true;
        }
        return false;
    }
}
