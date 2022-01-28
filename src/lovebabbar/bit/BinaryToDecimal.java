package lovebabbar.bit;

public class BinaryToDecimal {

    public static void main(String[] args) {
        System.out.print(convert(110));
    }

    private static int convert(int binary) {
        int index = 0;
        int ans = 0;
        while (binary != 0) {
            int bit = binary % 10;
            if (bit == 1) {
                ans += (int) Math.pow(2, index);
            }
            binary = binary / 10;
            index++;
        }
        return ans;
    }
}
