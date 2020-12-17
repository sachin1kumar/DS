package array;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        //1, 3, 5 ,4, 2
        //3, 2, 1 failed.
        //1, 1, 5
        //1 failed.
        int[] input = {1, 3, 5 ,4, 2};
        optimalSolution(input, 0, input.length - 1);
        //Time complexity is O(n) and space complexity is O(1)..
    }

    private static void optimalSolution(int[] input, int start, int end) {
        int index1 = 0;
        int index2 = 0;
        //Iterate array from last..
        for (int index = end; index >= 0; index--) {
            if (input[index - 1] < input[index]) {
                index1 = index - 1;
                break;
            }
        }

        //Iterate array again from the last..
        for (int index = end; index >= 0; index--) {
            if (input[index] > input[index1]) {
                index2 = index;
                break;
            }
        }

        //swap elements at index1 and index2..
        int temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;

        //reverse from index1 + 1 till last..
        int index = index1 + 1;
        int lastIndex = end;

        while(index < lastIndex) {
            int tempAlt = input[index];
            input[index] = input[lastIndex];
            input[lastIndex] = tempAlt;

            index++;
            lastIndex--;
        }


        //print output..
        for (int i = start; i <= end; i++) {
            System.out.print(input[i]+" ");
        }


    }

   /* private static void printPermutation(int[] input, int startIndex, int lastIndex) {
        if(startIndex == lastIndex) {
            System.out.println(Arrays.toString(input));
            return;
        }

        for (int i = startIndex; i <= lastIndex; i++) {
            //swap the char..
            swap(input, i, startIndex);

            printPermutation(input, startIndex + 1, lastIndex);

            //reset the char...we call it backtracking
            swap(input, i, startIndex);
        }
    }

    private static void swap(int[] input, int i, int startIndex) {
        int firstVal = input[startIndex];
        int secondVal = input[i];
        input[startIndex] =  secondVal;
        input[i] = firstVal;
    }*/
}
