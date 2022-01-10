package codingminutes.queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingChar {

    public static void main(String[] args) {
        printOutput("aabccbcd"); // a -1 b b b -1 -1 d
    }

    private static void printOutput(String input) {
        final int[] map = new int[27];
        final Queue<Character> queue = new LinkedList<>();

        for (int index = 0; index < input.length(); index++) {
            char ch = input.charAt(index);

            queue.add(ch);
            map[ch - 'a']++;

            while (!queue.isEmpty()) {
                int idx = queue.peek() - 'a';
                if (map[idx] > 1) {
                    queue.remove();
                } else {
                    System.out.print(queue.peek() + " ");
                    break;
                }
            }

            if (queue.isEmpty()) {
                System.out.print("-1 ");
            }
        }
    }
}
