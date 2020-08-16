package hackerrank.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class ClimbLeaderBoard {

    public static void main(String[] args) {
        int[] scores = {100, 90, 90, 80, 75, 60};
        int[] alice = {50, 65, 77, 90, 102};
        int[] result = climbingLeaderboard(scores, alice);
        for (int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        LinkedHashMap<Integer, Integer> map = initMap(scores);
        int[] result = new int[alice.length];
        int counter = 0;

        for(int index = 0; index < alice.length; index++) {
            result[counter] = getResult(map, alice[index]);
            counter++;
        }

        return result;
    }

    private static LinkedHashMap<Integer, Integer> initMap(int[] scores) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        int counter = 1;

        for (int index = 0; index < scores.length; index++) {
            if (!map.containsKey(scores[index])) {
                map.put(scores[index], counter);
                counter++;
            }
        }
        return map;
    }

    private static int getResult(LinkedHashMap<Integer, Integer> map, int element) {
        int gValue = 0;
        boolean isUpdated = false;
        int result = 0;

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(element >= key) {
                isUpdated = true;
                result = value;
                break;
            }
            gValue = value;
        }

        if (!isUpdated) {
            result = gValue + 1;
        }
        return result;
    }

}
