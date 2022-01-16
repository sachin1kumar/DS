package codingminutes.priorityqueue;

import java.util.PriorityQueue;

public class RopeProblem {

    public static void main(String[] args) {
        int N = 4;
        int[] ropes = {4, 3, 2, 6};
        System.out.println(getMinCost(ropes, N));
    }

    /*
    * Time complexity = O(NlogN + N)
    * */
    private static int getMinCost(int[] ropes, int N) {
        int cost = 0;
        int sum = 0;
        //add ropes to priority queue to get sorted ropes. O(NlogN)
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int index = 0; index < N; index++) {
            queue.add(ropes[index]);
        }
        //calculate cost in (N)
        if (queue.size() > 1) {
            sum += (queue.poll() + queue.poll());
            cost += sum;
        }
        while (!queue.isEmpty()) {
            sum += queue.poll();
            cost += sum;
        }
        return cost;
    }
}
