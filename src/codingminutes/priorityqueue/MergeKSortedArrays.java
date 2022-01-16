package codingminutes.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    static class Triplet implements Comparator<Triplet> {
        private int element;
        private int row;
        private int col;

        Triplet() {}
        Triplet(int element, int row, int col) {
            this.element = element;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compare(Triplet o1, Triplet o2) {
            return o1.element - o2.element;
        }

        public int getElement() {
            return element;
        }

        public void setElement(int element) {
            this.element = element;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }
    }

    public static void main(String[] args) {
        final int[][] input = {
                {10, 15, 20, 30},
                {2, 5, 8, 14, 24},
                {0, 11, 60, 90}
        };
        final int k = 3;
        printSortedArray(input, k);
    }

    private static void printSortedArray(int[][] input, int k) {
        PriorityQueue<Triplet> queue = new PriorityQueue<>(k, new Triplet());
        for (int index = 0; index < k; index++) {
            Triplet triplet = new Triplet(input[index][0], index, 0);
            queue.add(triplet);
        }
        while (!queue.isEmpty()) {
            Triplet triplet = queue.poll();
            System.out.print(triplet.element + " ");
            int col = triplet.getCol();
            int row = triplet.getRow();
            if (col < input[row].length - 1) {
                triplet.setCol(col + 1);
                triplet.setElement(input[row][triplet.getCol()]);
                queue.add(triplet);
            }
        }
    }
}
