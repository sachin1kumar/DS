package codingminutes.recursion;

public class ModuloExponential {

    public static void main(String[] args) {
        System.out.println(exponential(5, 3));
        System.out.println(fastExponential(3978432, 5, 1000000007));
    }

    /*
    * Time complexity : O(logn)
    * */
    private static int exponential(int a, int b) {
        int res = 1;

        while (b > 0) {
            if ((b & 1) != 0) {
                res = res * a; //suppose 5 * 5 * 5
            }
            a = a * a; // suppose 5 * 5
            b = b >> 1;
        }
        return res;
    }

    /*
    * (a * b) % n
    * */
    private static long fastExponential(long a, long b, long n) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) != 0) {
                res = (res * a % n) % n; //take mode of long type
            }
            a = (a % n * a % n) % n; //take mode of long type
            b = b >> 1;
        }
        return res;
    }
}
