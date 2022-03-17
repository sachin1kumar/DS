package lovebabbar.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeIntegerInWindow {

    public static void main(String[] args) {
        int[] input = {-8, 2, 3, -6, 10};
        System.out.println(getNegativeNumberInWindows(input, 2)); //[-8, 0, -6, -6]
        //int[] input = {12, -1, -7, 8, -15, 30, 16, 28};
        //System.out.println(getNegativeNumberInWindows(input, 3)); //[-1, -1, -7, -15, -15, 0]
    }

    private static List<Integer> getNegativeNumberInWindows(int[] input, int k) {
        final List<Integer> list = new ArrayList<>();
        if (input.length == 0) {
            return list;
        }
        int j = 0;
        final Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < input.length; i++) {
            j = i;
            if (((input.length-1) - i) + 1 < k) {
                return list;
            }
            int count = 0;
            while (j < input.length && count < k) {
                if (input[j] < 0) {
                    queue.add(input[j]);
                }
                j++;
                count++;
            }
            if (!queue.isEmpty()) {
                list.add(queue.peek());
            } else {
                list.add(0);
            }
            //clear the queue.
            queue.clear();
        }
        return list;
    }
}
