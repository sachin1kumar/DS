package linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReverseBlocks {

    private static int[] arr = {2,3,4};
    private static LLJava current = null;
    private static LLJava prev = null;

    private static ArrayList<LLJava> al = new ArrayList<>();
    private static ArrayList<HashMap<LLJava,LLJava>> list = new ArrayList<>();
    private static boolean isSet = false;


    public static void main(String[] args) {
        current = initList();

        iterate(current);
        //split LinkedList..
        for (int i = 0; i < arr.length; i++){
            splitList(arr[i]);
        }

        //retrieve al..
        for (int i = 0; i < al.size(); i++){
            reverseList(al.get(i));
        }

        //merge list.
        iterate(mergeList());
    }

    private static void reverseList(LLJava llJava) {
        LLJava prev = null;
        LLJava temp = null;
        LLJava curr = llJava;

        while (curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        HashMap<LLJava, LLJava> map = new HashMap<>();
        map.put(prev,getTail(prev));
        list.add(map);
    }

    private static void splitList(int index) {
        al.add(current);

        int i = 0;
        while (i < index){
            prev = current;
            current = current.next;
            i++;
        }

        if (prev != null && prev.next != null){
            current = prev.next;
            prev.next = null;
        }
    }

    private static LLJava mergeList() {
        LLJava head = null;
        LLJava val = null;

        for (int i = 0; i < list.size(); i++){
            HashMap<LLJava, LLJava> map = list.get(i);

            for (Map.Entry<LLJava, LLJava> entry: map.entrySet()){
                if (i == 0 && !isSet){
                    head = entry.getKey();
                    isSet = true;
                }
                prev = entry.getKey();
                if (val != null){
                    val.next = prev;
                }
                val = entry.getValue();
            }
        }
        if (val != null) {
            val.next = current;
        }
        return head;
    }

    private static LLJava initList(){
        LLJava head = new LLJava(1);
        LLJava two = new LLJava(2);
        LLJava three = new LLJava(3);
        LLJava four = new LLJava(4);
        LLJava five = new LLJava(5);
        LLJava six = new LLJava(6);
        LLJava seven = new LLJava(7);
        LLJava eight = new LLJava(8);
        LLJava nine = new LLJava(9);
        LLJava ten = new LLJava(10);
        LLJava eleven = new LLJava(11);
        /*LLJava head = new LLJava(8);
        LLJava two = new LLJava(7);
        LLJava three = new LLJava(6);
        LLJava four = new LLJava(5);
        LLJava five = new LLJava(4);
        LLJava six = new LLJava(3);
        LLJava seven = new LLJava(2);
        LLJava eight = new LLJava(1);*/

        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = ten;
        ten.next = eleven;

        return head;
    }

    private static void iterate(LLJava head){
        while (head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }

    private static LLJava getTail(LLJava head){
        LLJava tail = null;
        while (head != null){
            tail = head;
            head = head.next;
        }
        return tail;
    }
}
