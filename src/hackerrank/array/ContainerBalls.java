package hackerrank.array;

import java.util.ArrayList;

public class ContainerBalls {

    public static void main(String[] args) {
        int[][] container = {{1, 4},{2, 3}};
        checkResult(container);
    }

    private static void checkResult(int[][] container) {
        ArrayList<Integer> containers = new ArrayList<>();
        ArrayList<Integer> balls = new ArrayList<>();

        for(int indexC = 0; indexC < container.length; indexC++) {
            int rowSum = 0;
            int colSum = 0;
            for(int indexB = 0; indexB < container.length; indexB++) {
                rowSum += container[indexC][indexB];
                colSum += container[indexB][indexC];
            }
            containers.add(rowSum);
            balls.add(colSum);
        }

        containers.removeAll(balls);

        if(containers.isEmpty()) {
            System.out.println("Possible");
        }
        System.out.println("Possible");
    }
}
