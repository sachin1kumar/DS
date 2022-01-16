package codingminutes.priorityqueue.findingcabs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class CabImpl {

    public static void main(String[] args) {
        Cab c1 = new Cab();
        c1.setId("C1");
        c1.setX(1);
        c1.setY(2);
        c1.setDistance(-1);
        Cab c2 = new Cab();
        c2.setId("C2");
        c2.setX(2);
        c2.setY(1);
        c2.setDistance(-1);
        Cab c3 = new Cab();
        c3.setId("C3");
        c3.setX(3);
        c3.setY(2);
        c3.setDistance(-1);
        Cab c4 = new Cab();
        c4.setId("C4");
        c4.setX(0);
        c4.setY(1);
        c4.setDistance(-1);
        Cab c5 = new Cab();
        c5.setId("C5");
        c5.setX(2);
        c5.setY(3);
        c5.setDistance(-1);

        final List<Cab> input = List.of(c1, c2, c3, c4, c5);
        System.out.println("Calculated Distance:");
        System.out.println(calculateDistanceAndReturn(input));
        System.out.println("Sorted cabs:");
        List<Cab> cabs = calculateDistanceAndReturn(input);
        List<Cab> mutableCabs = new ArrayList<>(cabs);
        /*Collections.sort(mutableCabs, new Cab()); //will take O(nlogn)
        System.out.println(mutableCabs);*/

        //
        PriorityQueue<Cab> queue = calculateDistanceAndReturnQueue(mutableCabs);
        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.poll();
        }
    }

    private static List<Cab> calculateDistanceAndReturn(List<Cab> cabs) {
        //PriorityQueue queue = new PriorityQueue(cabs.size(), new Cab());
        for (int index = 0; index < cabs.size(); index++) {
            int distance = (int) Math.sqrt(Math.pow(cabs.get(index).getX(), 2) + Math.pow(cabs.get(index).getY(), 2));
            cabs.get(index).setDistance(distance);
            //queue.add(cabs.get(index).getDistance());
        }
        return cabs;
    }

    private static PriorityQueue<Cab> calculateDistanceAndReturnQueue(List<Cab> cabs) {
        PriorityQueue<Cab> queue = new PriorityQueue<>(cabs.size(), new Cab());
        for (int index = 0; index < cabs.size(); index++) {
            int distance = (int) Math.sqrt(Math.pow(cabs.get(index).getX(), 2) + Math.pow(cabs.get(index).getY(), 2));
            Cab cab = cabs.get(index);
            cab.setDistance(distance);
            queue.add(cab); //will take O(logn)
        }
        return queue;
    }
}
