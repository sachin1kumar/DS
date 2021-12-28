package codingminutes.sortingsearching;

public class RotatedSearch {

    public static void main(String[] args) {
        final int[] input = {4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println(getElement(input, 2));
    }

    private static int getElement(int[] input, int element) {
        int start = 0;
        int end = input.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (input[mid] == element) {
                return mid;
            }

            if (input[start] <= input[mid]) {
                //explore left.
                if (input[start] <= element && element <= input[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                //explore right.
                if (input[mid] <= element && element <= input[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
