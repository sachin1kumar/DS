package codingminutes.priorityqueue;

import java.util.PriorityQueue;

public class PriorityQueueImp {

    public static void main(String[] args) {
        /*
        * By default, it supports min heap implementation, in order to reverse the order provide
        * custom comparator in constructor.
        * */
        PriorityQueue<Integer> queue = new PriorityQueue<>(5, new CustomComparator());
        queue.add(10);
        queue.add(90);
        queue.add(5);
        queue.add(100);

        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.poll();
        }
    }
}
