package codingminutes.linkedlist;

public class RemoveDuplicatesSortedList {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(1);
        LinkedList head = list1;
        LinkedList list2 = new LinkedList(2);
        LinkedList list3 = new LinkedList(2);
        LinkedList list4 = new LinkedList(2);
        LinkedList list5 = new LinkedList(3);
        LinkedList list6 = new LinkedList(3);
        LinkedList list7 = new LinkedList(4);

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

        LinkedList curr = head;
        while (curr != null) {
            if (curr.next != null && (curr.data == curr.next.data)){
                LinkedList temp = curr.next.next;
                curr.next.next = null;
                curr.next = temp;
            } else {
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
