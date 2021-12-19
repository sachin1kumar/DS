package codingminutes;

import java.util.Arrays;

public class ProductProblem {

    public static void main(String[] args) {
        final int[] input = {1, 2, 3, 4}; //[24, 12, 8, 6]
        //final int[] input = {1, 2, 3, 0}; //[0, 0, 0, 6]
        System.out.println(Arrays.toString(getProducts(input)));
    }

    private static int[] getProducts(int[] input) {
        int length = input.length;

        int[] output = new int[length];

        int product = 1;
        //left
        for (int index = 0; index < length; index++) {
            product = product * input[index];
            output[index] = product;
        }

        //right
        product = 1;
        //iterate till 1 index.
        for (int index = length - 1; index > 0; index--) {
            output[index] = output[index - 1] * product;
            product = product * input[index];
        }
        output[0] = product;
        return output;
    }
}
