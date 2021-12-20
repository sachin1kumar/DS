package codingminutes.string;

public class DigitalClock {

    public static void main(String[] args) {
        System.out.println(getTime(125));
    }

    private static String getTime(int mins) {
        if (mins <= 0) {
            return "Unsupported mins";
        }

        int hrs = mins / 60;
        int min = mins % 60;

        StringBuilder h = new StringBuilder("");
        StringBuilder m = new StringBuilder("");

        if (min / 10 == 0) {
            m.append("0", 0, 1);
            m.append(min);
        } else {
            m.append(min);
        }

        return h.append(hrs) + ":" + m;
    }
}
