package codingminutes.string;

import java.util.ArrayList;
import java.util.List;

public class SearchAllProblem {

    public static void main(String[] args) {
        System.out.println(getIndexes("I liked the movie, acting in movie was great!", "movie"));
    }

    private static List<Integer> getIndexes(String bigString, String smallString) {
        final List<Integer> list = new ArrayList<>();

        int index = bigString.indexOf(smallString);
        while (index >= 0) {
            list.add(index);
            index = bigString.indexOf(smallString, index + 1);
        }

        return list;
    }
}
