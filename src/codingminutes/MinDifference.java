package codingminutes;

import codingminutes.util.CustomPair;

import java.util.Arrays;

public class MinDifference {

    public static void main(String[] args) {
        final int[] array1 = {23, 5, 10, 17, 30};
        final int[] array2 = {26, 134, 135, 14, 19};

        getPair(array1, array2);
    }

    /*
    * Time Complexity- O(NlogN) + O(N) = O(NlogN)
    * Space Complexity - O(1)
    * */
    private static void getPair(int[] array1, int[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;
        CustomPair customPair = new CustomPair(-1, -1);

        if (length1 == 0 && length2 == 0) {
            System.out.println("No such pair");
        }

        if (length1 == 0 || length2 == 0) {
            System.out.println("No such pair");
        }

        if (length1 != 0) {
            Arrays.sort(array1);
        }

        if (length2 != 0) {
            Arrays.sort(array2);
        }

        int firstIndex = 0;
        int secondIndex = 0;

        int diff = Integer.MAX_VALUE;

        while (firstIndex < length1 && secondIndex < length2) {
            int currentDiff = array1[firstIndex] - array2[secondIndex];
            if (Math.abs(currentDiff) < diff) {
                diff = Math.abs(currentDiff);
                System.out.println(array1[firstIndex]+"LL"+array2[secondIndex]);
                customPair.setKey(array1[firstIndex]);
                customPair.setValue(array2[secondIndex]);
            }

            if (array1[firstIndex] < array2[secondIndex]) {
                firstIndex++;
            } else if (array1[firstIndex] > array2[secondIndex]) {
                secondIndex++;
            } else {
                firstIndex++;
                secondIndex++;
            }
        }

        while (secondIndex < length2) {
            int currentDiff = 0;
            int tempFirstIndex = firstIndex;
            if (tempFirstIndex == length1) {
               currentDiff = array1[tempFirstIndex - 1] - array2[secondIndex];
                if (Math.abs(currentDiff) < diff) {
                    System.out.println(array1[tempFirstIndex - 1]+"LL2"+array2[secondIndex]);
                    diff = Math.abs(currentDiff);
                    customPair.setKey(array1[tempFirstIndex - 1]);
                    customPair.setValue(array2[secondIndex]);
                }
            }
            secondIndex++;
        }

        while (firstIndex < length1) {
            int currentDiff = 0;
            int tempSecondIndex = secondIndex;
            if (tempSecondIndex == length1) {
                currentDiff = array1[firstIndex] - array2[tempSecondIndex - 1];
                if (Math.abs(currentDiff) < diff) {
                    System.out.println(array1[firstIndex]+"LL3"+array2[tempSecondIndex - 1]);
                    diff = Math.abs(currentDiff);
                    customPair.setKey(array1[firstIndex]);
                    customPair.setValue(array2[tempSecondIndex - 1]);
                }
            }
            firstIndex++;
        }

        System.out.println(customPair.getKey()+":"+customPair.getValue());

    }
}
