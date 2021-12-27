package codingminutes.sortingsearching;

import java.util.ArrayList;
import java.util.List;

import static codingminutes.BinarySearchUtil.getElementIndex;

public class StairCaseSearch {

    public static void main(String[] args) {
        final int[][] input = {{1, 4, 9}, {2, 5, 10}, {6, 7, 11}};
        System.out.println(getIndex(input, 10)); //{1, 2}
    }

    /*
    * Time complexity- O(NlogN)
    * */
    private static List<Integer> getIndex(int[][] input, int element) {
        final List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(-1);
        for (int index = 0; index < input[0].length; index++) {
            int searchedIndex = getElementIndex(input[index], 0, input[index].length - 1, element);
            if (searchedIndex != -1) {
                list.clear();
                list.add(index);
                list.add(searchedIndex);
                return list;
            }
        }
        return list;
    }


}
