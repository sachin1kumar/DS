package codingminutes.stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

    public static void main(String[] args) {
        int[] stockPrices = {100, 80, 60, 70, 60, 75, 85};
        int size = stockPrices.length;
        System.out.println(Arrays.toString(Arrays.stream(getSpan(stockPrices, size)).toArray()));
    }

    private static int[] getSpan(int[] stockPrices, int size) {
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[size];
        if (size > 0) {
            stack.push(0);
            span[0] = 1;
        }
        for (int index = 1; index < size; index++) {
            if (stockPrices[stack.peek()] > stockPrices[index]) {
                span[index] = index - stack.peek();
            } else {
                while (!stack.isEmpty() && stockPrices[stack.peek()] <= stockPrices[index]) {
                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    span[index] = index - stack.peek();
                } else {
                    span[index] = index + 1;
                }
            }
            stack.push(index);
        }
        return span;
    }
}
