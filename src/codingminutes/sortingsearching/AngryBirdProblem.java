package codingminutes.sortingsearching;

import java.util.Arrays;

public class AngryBirdProblem {

    public static void main(String[] args) {
        int noOfBirds = 3;
        int[] nests = {2, 4, 1, 8, 9};
        int nestSize = nests.length;

        System.out.println(getMinimumDistance(noOfBirds, nests, nestSize));
    }

    private static int getMinimumDistance(int noOfBirds, int[] nests, int nestSize) {
        //First sort nests list in O(nlogn)
        Arrays.sort(nests);
        //Sorted List: 1, 2, 4, 8, 9

        //Now create search space to perform binary search.
        int start = 0;
        int end = nests[nestSize - 1] - nests[0];
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            boolean canPlace = isBirdCanPlace(noOfBirds, nests, nestSize, mid);

            if (canPlace) {
                ans = mid;
                //explore right.
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private static boolean isBirdCanPlace(int noOfBirds, int[] nests, int nestSize, int mid) {
        int birds = 1;
        int location = nests[0];

        for (int index = 1; index < nestSize; index++) {
            int currentLocation = nests[index];
            if ((currentLocation - location) >= mid) {
                location = nests[index];
                birds++;
            }
            if (birds == noOfBirds) {
                return true;
            }
        }
        return false;
    }
}
