package codingminutes.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementArr {


    public static void main(String[] args) {
        int[] input =  {4, 3, 5, 2}; //output 5, 5, MAX, MAX
        int[] output = getNextMax(input);

        for (int index = 0; index < output.length; index++) {
            System.out.print(output[index]+" ");
        }
    }

    private static int[] getNextMax(int[] input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);

        for (int index = input.length - 1; index >= 0; index--) {
            int curr = input[index];
            while (!stack.isEmpty() && stack.peek() <= curr) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                input[index] = stack.peek();
            }
            stack.push(curr);
        }
        return input;
    }
}
