package codingminutes.linkedlist;

public class RecursiveReverseLinkedList {

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

        LinkedList result = reverseRecursively(head);
        printList(result);
    }

    private static LinkedList reverseRecursively(LinkedList head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        LinkedList sHead = reverseRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return sHead;
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
