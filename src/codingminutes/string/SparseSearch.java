package codingminutes.string;

public class SparseSearch {

    public static void main(String[] args) {
        final String[] input = {"ai", "", "", "bat", "", "", "car", "cat", "", "", "dog", ""}; //find bat -> 3
        //System.out.println(getSearchIndex(input, "bat")); //3
        System.out.println(getSearchIndex(input, "cat")); //7

    }

    private static int getSearchIndex(String[] input, String searchElement) {
        int start = 0;
        int end = input.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            int midLeft = mid - 1;
            int midRight = mid + 1;
            if (input[mid].equalsIgnoreCase("")) {
                //update mid.
                while (true) {
                    if (midRight > end && midLeft < start) {
                        return -1;
                    } else if (midRight <= end && !input[midRight].equalsIgnoreCase("")) {
                        mid = midRight;
                        break;
                    } else if (midLeft >= start && !input[midLeft].equalsIgnoreCase("")) {
                        mid = midLeft;
                        break;
                    }
                    midLeft--;
                    midRight++;
                }
            }
            if (searchElement.equalsIgnoreCase(input[mid])) {
                return mid;
            } else if (searchElement.compareTo(input[mid]) < 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
