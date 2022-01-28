package lovebabbar;

public class Pattern {

    public static void main(String[] args) {
        printPattern(5);
    }

    private static void printPattern(int n) {
        int n_ = n;
        int starCount = 0;
        for (int i = 1; i <= n; i++) {
            //first triangle.
            for (int j = 1; j <= n_ ; j++) {
                System.out.print(j+" ");
            }
            //star triangle.
            int s_ = starCount;
            while (s_!=0) {
                System.out.print("* ");
                s_--;
            }
            starCount+=2;
            //second triangle.
            int h = n_;
            while (h != 0) {
                System.out.print(h+" ");
                h--;
            }
            System.out.println();
            n_--;
        }
    }
}
