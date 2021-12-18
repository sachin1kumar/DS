package codingminutes;


import codingminutes.util.CustomPair;

import java.util.*;

public class MinSwap {

    public static void main(String[] args) {
        //int[] input = {5, 4, 3, 2, 1}; //output: 2
        int[] input = {10, 11, 5, 4, 3, 2, 1}; //output: 4
        //int[] input = {2, 4, 5, 1, 3}; //output: 3

        System.out.println(getOldPairs(input));
        final List<CustomPair> list = getOldPairs(input);
        Collections.sort(list);
        System.out.println("Sorted list:"+list);

        System.out.println(getMinSwap(list));
    }

    private static List<CustomPair> getOldPairs(int[] input) {
        final List<CustomPair> customPairs = new ArrayList<>();
        for (int index = 0; index < input.length; index++) {
            final CustomPair customPair = new CustomPair(input[index], index);
            customPairs.add(customPair);
        }
        return customPairs;
    }

    /*
    * Time complexity - O(NlogN)
    * Space complexity - O(N)
    * */
    private static int getMinSwap(List<CustomPair> sortedInput) {
        final boolean[] visited = new boolean[sortedInput.size()];

        int swap = 0;

        for (int index = 0; index < sortedInput.size(); index++) {
            //if element is already visited or element is in right position.
            if (visited[index] || sortedInput.get(index).getValue() == index) {
                continue;
            }
            //visiting the element for the first time.
            int node = index;
            int cycle = 0;
            while (!visited[node]) {
                visited[node] = true;
                node = sortedInput.get(node).getValue();
                cycle += 1;
            }
            swap += (cycle - 1);
        }
        return swap;
    }
}
