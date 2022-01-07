package codingminutes.linkedlist;

public class ReverseKLinkedList {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(1);
        LinkedList head = list1;
        LinkedList list2 = new LinkedList(2);
        LinkedList list3 = new LinkedList(3);
        LinkedList list4 = new LinkedList(4);
        LinkedList list5 = new LinkedList(5);
        LinkedList list6 = new LinkedList(6);
        LinkedList list7 = new LinkedList(7);
        LinkedList list8 = new LinkedList(8);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
        list5.next = list6;
        list6.next = list7;
        list7.next = list8;

        LinkedList result = reverseKRecursively(head, 3);
        printList(result);
    }

    private static LinkedList reverseKRecursively(LinkedList head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        //reverse first k node iteratively.
        int count = 1;
        LinkedList temp = head;
        LinkedList ptr = null;
        LinkedList temp_ = null;

        while (temp != null && count <= k) {
            temp_ = temp.next;
            temp.next = ptr;
            ptr = temp;
            temp = temp_;
            count++;
        }
        //call recursion for next k codes and reverse them.
        //No connect the two reversed lists.
        //here head is the last pointer of first reversed node.
        if (temp_ != null) {
            head.next = reverseKRecursively(temp_, k);;
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
