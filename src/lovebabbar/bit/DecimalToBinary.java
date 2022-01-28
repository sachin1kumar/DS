package lovebabbar.bit;

public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.println(convertToBinary(4));
    }

    private static int convertToBinary(int num) {
        int ans = 0;
        int index = 0;
        while (num != 0) {
            int bit = num & 1;
            ans = (bit * (int) Math.pow(10, index)) + ans;
            num = num >> 1;
            index++;
        }
        return ans;
    }
}
