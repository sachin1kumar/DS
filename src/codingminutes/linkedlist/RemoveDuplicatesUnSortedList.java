package codingminutes.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesUnSortedList {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(1);
        LinkedList head = list1;
        LinkedList list2 = new LinkedList(2);
        LinkedList list3 = new LinkedList(4);
        LinkedList list4 = new LinkedList(3);
        LinkedList list5 = new LinkedList(3);
        LinkedList list6 = new LinkedList(2);
        LinkedList list7 = new LinkedList(2);

        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
        list5.next = list6;
        list6.next = list7;
        printList(removeDuplicates(head));
    }

    private static LinkedList removeDuplicates(LinkedList head) {
        if (head == null) {
            return null;
        }
        final Map<Integer, Boolean> map = new HashMap<>();
        LinkedList curr = head;
        LinkedList prev = null;
        while (curr != null) {
            if (map.containsKey(curr.data)) {
                LinkedList temp = curr.next;
                curr.next = null;
                prev.next = temp;
                curr = temp;
            } else {
                map.put(curr.data, true);
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    private static void printList(LinkedList head) {
        if (head == null) {
            System.out.println("Empty List");
        }
        LinkedList temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
