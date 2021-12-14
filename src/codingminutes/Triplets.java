package codingminutes;

import java.util.Arrays;

public class Triplets {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 15};
        printTriplets(input, 18);
    }

    //Time complexity O(n2)
    private static void printTriplets(int[] input, int target) {
        int length = input.length;

        if (length < 3) {
            System.out.println("No triplets present");
            return;
        }

        //sort the array
        Arrays.sort(input);

        for (int index = 0; index <= length - 3; index++) {
            int left = index + 1;
            int right = length - 1;
            int search = target - input[index];

            while (left < right) {
                if (input[left] + input[right] > search) {
                    right--;
                } else if (input[left] + input[right] < search) {
                    left++;
                } else {
                    System.out.println(input[index] + " "+ input[left]+" "+input[right]);
                    right--;
                    left++;
                }
            }
        }
    }
}
