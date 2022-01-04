package codingminutes.recursion;

public class Brackets {

    /*
     * input : 2
     * ()()
     * (())
     * */
    public static void main(String[] args) {
        printOutput("", 0, 2, 0, 0);
    }

    /*
    * Space complexity: O(n)
    * Time complexity: O(2pown)
    * */
    private static void printOutput(String output, int index, int inputLen,
                                    int openCount, int closeCount) {
        if (index == 2 * inputLen) {
            System.out.println(output);
            return;
        }

        if (openCount < inputLen) {
            printOutput(output + '(', index + 1, inputLen, openCount + 1, closeCount);
        }

        if (closeCount < openCount) {
            printOutput(output + ')', index + 1, inputLen, openCount, closeCount + 1);
        }
    }


}
