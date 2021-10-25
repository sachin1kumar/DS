package test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        List<String> inputList = new ArrayList<>();
        inputList.add("A");
        inputList.add("B");

        modifyList(inputList);
        System.out.println("First:"+inputList);

        modifyList2(inputList);
        System.out.println("Second:"+inputList);

        modifyList3(inputList);
        System.out.println("Third:"+inputList);

       // modifyList4(inputList); //Compile time error here..
        System.out.println("Fourth:"+inputList);
    }

    private static void modifyList(List<String> stringList) {
        stringList.add("C");
    }

    private static void modifyList2(List<String> stringList) {
        stringList = null;
    }

    private static void modifyList3(List<String> stringList) {
        stringList.clear();
    }

    private static void modifyList4(List<Object> objects) {
        for (Object o: objects) {
            System.out.println(" "+o);
        }
        System.out.println();
    }
}
