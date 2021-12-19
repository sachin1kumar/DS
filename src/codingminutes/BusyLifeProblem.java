package codingminutes;

import codingminutes.util.CustomPair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BusyLifeProblem {

    public static void main(String[] args) {
        System.out.println(getMaxActivities(initCustomPair()));
    }

    /*
    * Time complexity - O(NlogN) + O(N) + O(logN) = O(NlogN)
    * */
    private static int getMaxActivities(List<CustomPair> pairs) {
        int size = pairs.size();
        int maxActivity = Integer.MIN_VALUE;

        for (int index = 0; index < size; index++) {
            int activityCount = 1;
            int value = pairs.get(index).getValue();
            int searchIndex = performBinarySearch(pairs, value);
            while (searchIndex != -1) {
                value = pairs.get(searchIndex).getValue();
                searchIndex = performBinarySearch(pairs, value);
                activityCount++;
            }
            if (activityCount > maxActivity) {
                maxActivity = activityCount;
            }
        }
        return maxActivity;
    }

    /*
    * Will return pairs in sorted order.
    * Time complexity - O(NLogN)
    * */
    private static List<CustomPair> initCustomPair() {
        final CustomPair customPair1 = new CustomPair(7, 9);
        final CustomPair customPair2 = new CustomPair(0, 10);
        final CustomPair customPair3 = new CustomPair(4, 5);
        final CustomPair customPair4 = new CustomPair(8, 9);
        final CustomPair customPair5 = new CustomPair(4, 10);
        final CustomPair customPair6 = new CustomPair(5, 7);

        final List<CustomPair> pairs = new ArrayList<>();
        pairs.add(customPair1);
        pairs.add(customPair2);
        pairs.add(customPair3);
        pairs.add(customPair4);
        pairs.add(customPair5);
        pairs.add(customPair6);

        Collections.sort(pairs);

        return pairs;
    }

    /*
    * Time complexity - O(logN)
    * */
    private static int performBinarySearch(List<CustomPair> customPairs, int key) {
        int start = 0;
        int end = customPairs.size() - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (customPairs.get(mid).getKey() == key) {
                return mid;
            } else if (key < customPairs.get(mid).getKey()) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
