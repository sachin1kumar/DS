package array;

public class Median2DArray {

    public static void main(String[] args) {
        int[][] input = {
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };

        //sort the input..
        for (int index = 0; index < input.length - 1; index++) {
            int first = index;
            int second = index + 1;
            int firstIterateIndex = 0;
            int secondIterateIndex = 0;

            int sizeFirst = input[first].length;
            //int sizeSecond = input[second].length;

            while (firstIterateIndex < sizeFirst
                    && secondIterateIndex < sizeFirst) {
                if (input[first][firstIterateIndex] < input[second][secondIterateIndex]) {
                    firstIterateIndex++;
                } else if (input[first][firstIterateIndex] > input[second][secondIterateIndex]) {
                    //swap
                    int temp = input[first][firstIterateIndex];
                    input[first][firstIterateIndex] = input[second][secondIterateIndex];
                    input[second][secondIterateIndex] = temp;
                    firstIterateIndex++;
                } else {
                    firstIterateIndex++;
                    secondIterateIndex++;
                }
            }
        }

        //print the sorted matrix..
        for (int i = 0; i < input[0].length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j]+" ");
            }
            System.out.println();
        }
    }
}
