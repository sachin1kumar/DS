package codingminutes.sortingsearching;

import codingminutes.BinarySearchUtil;

public class FrequencyCount {

    public static void main(String[] args) {
        final int[] input = {0, 1, 1, 1, 1, 2, 2, 2, 3, 4, 4, 5, 10}; // when 2 -> 3
        // 1-> 4 ok
        // 2 -> 3 ok
        // 0 -> 1 ok
        //4 -> 2 ok
        // 3 -> 1 ok
        // 5 -> 1 ok
        // 10 -> 1 ok
        System.out.println(getFrequency(input, 1));
    }

    private static int getFrequency(int[] input, int element) {
        final int length = input.length;
        if (length == 0) {
            return -1;
        }
        int start = 0;
        int end = length - 1;
        int lowerBound = BinarySearchUtil.getElementIndex(input, start, end, element);
        if (lowerBound == -1) {
            return -1;
        } else {
            //find element on left.
            end = lowerBound - 1;
            int currentBound = BinarySearchUtil.getElementIndex(input, start, end, element);
            if (currentBound != -1) {
                lowerBound = currentBound;
            }
        }
        start = end + 2;
        end = length - 1;
        int upperBound = 0;
        //find element on right.
        int currentBound = BinarySearchUtil.getElementIndex(input, start, end, element);
        if (currentBound != -1) {
            upperBound = currentBound;
        } else {
            upperBound = lowerBound;
        }
        System.out.println(upperBound+":"+lowerBound);
        return (upperBound - lowerBound) + 1;
    }
}
