package hackerrank.string;

public class Encryption {
    public static void main(String[] args) {
        System.out.println(encryption("feedthedog"));
    }

    static String encryption(String s) {
        StringBuilder str = new StringBuilder(s);

        System.out.println(str);

        int L = str.length();

        System.out.println(L);

        double root = Math.sqrt(L);
        System.out.println("root:"+root);

        int floor = (int)Math.floor(root);
        int ceil = (int)Math.ceil(root);

        System.out.println("floor:"+floor);
        System.out.println("ceil:"+ceil);

        int prod = floor * ceil;

        if(prod < L) {
            floor = ceil;
        }

        int p = 0;
        int len = str.length();

        char[][] encode = new char[floor][ceil];

        for(int i = 0; i < floor; i++) {
            for(int j = 0; j < ceil; j++) {
                if(p >= len) {
                    encode[i][j] = ' ';
                } else {
                    encode[i][j] = str.charAt(p);
                    p++;
                }
            }
        }

        StringBuilder result = new StringBuilder("");
        int resLength = result.length();

        for(int i = 0; i < ceil; i++) {
            for(int j = 0; j < floor; j++) {
                result.append(encode[j][i]+"");
            }
            resLength = result.length();
            if(result.charAt(resLength - 1) != ' ') {
                result.append(" ");
            }

        }
        resLength = result.length();
        result.deleteCharAt(resLength - 1);
        return result.toString();
    }
}
