import java.util.ArrayList;
import java.util.List;

public class SolveEqn {


    public static void main(String args[])
    {
        int gst = 15;
        int finalValue = 187;
        int finalgst = 100 + gst;
        System.out.println(solveEquation(finalgst+"x="+finalValue));
    }



        public static String coeff(String x) {
            if (x.length() > 1 && x.charAt(x.length() - 2) >= '0' && x.charAt(x.length() - 2) <= '9')
                return x.replace("x", "");
            return x.replace("x", "1");
        }

        public static String solveEquation(String equation) {
            String[] lr = equation.split("=");
            float lhs = 0, rhs = 0;
            for (String x: breakIt(lr[0])) {
                if (x.indexOf("x") >= 0) {
                    lhs += Float.parseFloat(coeff(x));
                } else
                    rhs -= Float.parseFloat(x);
            }
            for (String x: breakIt(lr[1])) {
                if (x.indexOf("x") >= 0)
                    lhs -= Float.parseFloat(coeff(x));
                else
                    rhs += Float.parseFloat(x);
            }
            if (lhs == 0) {
                if (rhs == 0)
                    return "Infinite solutions";
                else
                    return "No solution";
            }
            return "x=" + rhs / lhs;
        }
        public static List < String > breakIt(String s) {
            List< String > res = new ArrayList< >();
            String r = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                    if (r.length() > 0)
                        res.add(r);
                    r = "" + s.charAt(i);
                } else
                    r += s.charAt(i);
            }
            res.add(r);
            return res;
        }


}