package codingminutes.slidingwindow.subarrprobs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxElementInSubArrsOfSizeK {

    /*
    * Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
        Output: 3 3 4 5 5 5 6
        Explanation:
            Maximum of 1, 2, 3 is 3
            Maximum of 2, 3, 1 is 3
            Maximum of 3, 1, 4 is 4
            Maximum of 1, 4, 5 is 5
            Maximum of 4, 5, 2 is 5
            Maximum of 5, 2, 3 is 5
            Maximum of 2, 3, 6 is 6
    * */


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        System.out.println(getMax(arr, 9, 3));
    }

    private static List<Integer> getMax(int arr[], int n, int k) {
        final List<Integer> output = new ArrayList<>();
        // Create a Double Ended Queue, Qi
        // that will store indexes of array elements
        // The queue will store indexes of
        // useful elements in every window and it will
        // maintain decreasing order of values
        // from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()]
        // are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<Integer>();

        /* Process first k (or first window)
        elements of array */
        int i;
        for (i = 0; i < k; i++) {
            // For every element, the previous
            // smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty() && arr[i] >=
                    arr[Qi.peekLast()])
                // Remove from rear
                Qi.removeLast();

            // Add new element at rear of queue
            Qi.addLast(i);
        }
        // Process rest of the elements,
        // i.e., from arr[k] to arr[n-1]
        for (; i < n; i++) {
            System.out.println("index i:"+ i);

            // The element at the front of the
            // queue is the largest element of
            // previous window, so print it
            /// ----
            output.add(arr[Qi.peek()]);

            // Remove the elements which
            // are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <=
                    i - k)
                Qi.removeFirst();

            // Remove all elements smaller
            // than the currently
            // being added element (remove
            // useless elements)
            while ((!Qi.isEmpty()) && arr[i] >=
                    arr[Qi.peekLast()])
                Qi.removeLast();

            // Add current element at the rear of Qi
            Qi.addLast(i);
        }
        // Print the maximum element of last window
        //-----
        output.add(arr[Qi.peek()]);
        return output;
    }
}
