package hackerrank.array;

import java.util.ArrayList;

public class JumpingClouds {

    public static void main(String[] args) {
        int[] input = {0, 0, 0, 0, 1, 0};
        System.out.println(jumpingOnClouds(input));
    }

    private static int jumpingOnClouds(int[] c) {

        ArrayList<Integer> list = new ArrayList<>();

        for(int index = 0; index < c.length; index++) {
            if(c[index] != 1) {
                list.add(index);
            }
        }

        int listSize = list.size();

        ArrayList<Integer> listSecond = new ArrayList<>();

        for(int index = 0; index < list.size(); index = index + 2) {
            if (index < list.get(index)) {
                listSecond.add(list.get(index - 1));
            }
            listSecond.add(list.get(index));
        }

        if(listSecond.size() < listSize) {
            return listSecond.size() - 1;
        }
        return listSize - 1;
    }
}
