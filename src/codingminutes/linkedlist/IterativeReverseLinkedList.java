package codingminutes.linkedlist;

public class IterativeReverseLinkedList {

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

        LinkedList result = reverseIteratively(head);
        printList(result);
    }

    private static LinkedList reverseIteratively(LinkedList head) {
        LinkedList temp = head;
        LinkedList ptr = null;
        LinkedList temp_ = null;

        while (temp != null) {
            temp_ = temp.next;
            temp.next = ptr;
            ptr = temp;
            temp = temp_;
        }
        return ptr;
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
