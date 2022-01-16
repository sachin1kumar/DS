package codingminutes.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {

    private static final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private static final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    /*Total time complexity = O(NlogN)
    * */
    public static void main(String[] args) {
        int[] input = {10, 5, 2, 3, 0, 12, 18, 20, 22};
        for (int index = 0; index < input.length; index++) {
            insertNum(input[index]);
            System.out.print(getMedian() + " ");
        }
    }
    /*O(logN)*/
    private static void insertNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
    /* O(1)    * */
    private static double getMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2;
        }
        return maxHeap.peek();
    }
}
