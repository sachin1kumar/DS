package codingminutes.hashing;

import codingminutes.linkedlist.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class BreakTheChain {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(1);
        LinkedList head = list1;
        LinkedList list2 = new LinkedList(2);
        LinkedList list3 = new LinkedList(3);
        LinkedList list4 = new LinkedList(4);
        LinkedList list5 = new LinkedList(5);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
        list5.next = list2;
        //printList(removeCycle(head));
        printList(removeCycleRunnerTechnique(head));
    }

    /*
    Using Hashing will take O(n) space.
    * */
    private static LinkedList removeCycle(LinkedList head) {
        if (head == null) {
            return null;
        }
        LinkedList temp = head;
        LinkedList prev = null;
        final Set<LinkedList> set = new HashSet<>();
        while (temp != null) {
            if (set.contains(temp)) {
                break;
            }
            set.add(temp);
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        return head;
    }

    /*
    * Space complexity - O(1)
    * */
    private static LinkedList removeCycleRunnerTechnique(LinkedList head) {
        if (head == null) {
            return null;
        }
        LinkedList slow = head;
        LinkedList fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        slow.next = null;
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
