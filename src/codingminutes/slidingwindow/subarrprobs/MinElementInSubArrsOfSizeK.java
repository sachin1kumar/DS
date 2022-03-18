package codingminutes.slidingwindow.subarrprobs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MinElementInSubArrsOfSizeK {

       /*
    * Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
        Explanation:
            Maximum of 1, 2, 3 is 1
            Maximum of 2, 3, 1 is 1
            Maximum of 3, 1, 4 is 1
            Maximum of 1, 4, 5 is 1
            Maximum of 4, 5, 2 is 2
            Maximum of 5, 2, 3 is 2
            Maximum of 2, 3, 6 is 2
    * */


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        System.out.println(getMin(arr, 9, 3));
    }

    public static List<Integer> getMin(int[] arr, int size, int k) {
        final List<Integer> output = new ArrayList<>();
        final Deque<Integer> deque = new LinkedList<>();
        int i = 0;
        for (;i< k; i++) {
            while (!deque.isEmpty() && arr[i] <= arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        for (;i < size; i++) {
            output.add(arr[deque.peek()]);
            while (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && arr[i] <= arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        output.add(arr[deque.peek()]);
        return output;
    }
}
