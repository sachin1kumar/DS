package array;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeEvenOdd {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 4, 5, 6, 8, 8};

        //rearrange array..
        ArrayList<Integer> output = rearrange(arr);

        //print output.
        for (int i = 0; i < output.size(); i++) {
            System.out.print(output.get(i)+" ");
        }
        System.out.println();
    }

    private static ArrayList<Integer> rearrange(int[] arr) {
        //Sort the array..
        Arrays.sort(arr);

        //find mid and init two pointers.
        int size = arr.length;
        int mid = 0;
        int i = 0;
        int j = 0;

        if (size % 2 != 0) {
            mid = size / 2;
        } else {
            mid = (size / 2) - 1;
        }
        i = mid;
        j = mid + 1;

        //Create arraylist for output..
        ArrayList<Integer> output = new ArrayList<>();
        while (i >= 0 && j <= size) {
            output.add(arr[i]);
            output.add(arr[j]);
            i--;
            j++;
        }

        return output;
    }
}
