package codingminutes.linkedlist;

public class LinkedListMergeSort {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(5);
        LinkedList head = list1;
        LinkedList list2 = new LinkedList(1);
        LinkedList list3 = new LinkedList(3);
        LinkedList list4 = new LinkedList(0);
        LinkedList list5 = new LinkedList(2);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;

        LinkedList result = mergeSort(head);
        printList(result);
    }


    private static LinkedList mergeSort(LinkedList head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedList mid = getMid(head);

        LinkedList firstList = head;
        LinkedList secondList = mid.next;
        mid.next = null;

        firstList = mergeSort(firstList);
        secondList = mergeSort(secondList);
        return merge(firstList, secondList);
    }

    private static LinkedList getMid(LinkedList head) {
        LinkedList slow = head;
        LinkedList fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static LinkedList merge(LinkedList firstList, LinkedList secondList) {
        if (firstList == null && secondList == null) {
            return null;
        }
        if (firstList == null) {
            return secondList;
        }
        if (secondList == null) {
            return firstList;
        }
        LinkedList dummy = null;
        if (firstList.data < secondList.data) {
            dummy = firstList;
            dummy.next = merge(firstList.next, secondList);
        } else {
            dummy = secondList;
            dummy.next = merge(firstList, secondList.next);
        }
        return dummy;
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
