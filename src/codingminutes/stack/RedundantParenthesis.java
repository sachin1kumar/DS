package codingminutes.stack;

import java.util.Stack;

public class RedundantParenthesis {

    public static void main(String[] args) {
        //System.out.println(isRedundant("((a+b)+c)")); //false
        System.out.println(isRedundant("((a+b))")); //true
    }

    private static boolean isRedundant(String expression) {
        int length = expression.length();
        if (length == 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int index = 0; index < length; index++) {
            char ch = expression.charAt(index);

            if (ch == ')') {
                boolean isOperatorPresent = false;
                char popChar = stack.pop();
                while (popChar != '(') {
                    if (popChar == '+' || popChar == '-' || popChar == '*' || popChar == '/') {
                        isOperatorPresent = true;
                    }
                    popChar = stack.pop();
                }
                if (!isOperatorPresent && stack.empty()) {
                    return true;
                }
            } else {
                stack.push(ch);
            }
        }
        return false;
    }
}
