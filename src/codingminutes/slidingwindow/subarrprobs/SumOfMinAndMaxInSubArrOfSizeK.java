package codingminutes.slidingwindow.subarrprobs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SumOfMinAndMaxInSubArrOfSizeK {
    /*
    * Merge the code for min and max element in a subarray of size k.
    * Don't forget to create two deque in this problem.
    * */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        System.out.println(getSum(arr, 9, 3));
    }

    private static List<Integer> getSum(int[] arr, int size, int k) {
        final List<Integer> output = new ArrayList<>();
        final Deque<Integer> minDeque = new LinkedList<>();
        final Deque<Integer> maxDeque = new LinkedList<>();

        int i = 0;
        for (;i< k; i++) {
            while (!minDeque.isEmpty() && arr[i] <= arr[minDeque.peekLast()]) {
                minDeque.removeLast();
            }
            minDeque.addLast(i);
            while (!maxDeque.isEmpty() && arr[i] >= arr[maxDeque.peekLast()]) {
                maxDeque.removeLast();
            }
            maxDeque.addLast(i);
        }

        for (;i < size; i++) {
            output.add(arr[minDeque.peek()]+arr[maxDeque.peek()]);
            while (!minDeque.isEmpty() && minDeque.peek() <= i - k) {
                minDeque.removeFirst();
            }
            while (!minDeque.isEmpty() && arr[i] <= arr[minDeque.peekLast()]) {
                minDeque.removeLast();
            }
            minDeque.addLast(i);

            while (!maxDeque.isEmpty() && maxDeque.peek() <= i - k) {
                maxDeque.removeFirst();
            }
            while (!maxDeque.isEmpty() && arr[i] >= arr[maxDeque.peekLast()]) {
                maxDeque.removeLast();
            }
            maxDeque.addLast(i);
        }
        output.add(arr[minDeque.peek()]+arr[maxDeque.peek()]);
        return output;
    }
}
