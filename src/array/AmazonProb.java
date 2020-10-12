package array;

import java.util.ArrayList;

public class AmazonProb {

    public static void main(String[] args) {
        String s = "|**|*|";
        int strCount = 0;
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Character> stack = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                strCount++;
            }
            if (s.charAt(i) == '|') {
                stack.add('|');
            }
            if (stack.size() == 2) {
                res.add(strCount);
                stack.remove(1);
                strCount = 0;
            }
            if (stack.size() == 0) {
                strCount = 0;
            }
        }

        //print out
        int sum = 0;
        for (Integer re : res) {
            sum += re;
        }

        System.out.println(sum);
    }
}
