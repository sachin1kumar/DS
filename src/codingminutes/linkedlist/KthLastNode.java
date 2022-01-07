package codingminutes.linkedlist;

public class KthLastNode {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(1);
        LinkedList head = list1;
        LinkedList list2 = new LinkedList(2);
        LinkedList list3 = new LinkedList(3);
        LinkedList list4 = new LinkedList(4);
        LinkedList list5 = new LinkedList(5);
        LinkedList list6 = new LinkedList(6);
        LinkedList list7 = new LinkedList(7);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
        list5.next = list6;
        list6.next = list7;

        int k = 3;

        LinkedList result = getNode(head, k);
        System.out.println(result.data);
    }

    private static LinkedList getNode(LinkedList head, int k) {
        if (head ==  null || k <= 0) {
            return null;
        }
        LinkedList first = head;
        LinkedList second = head;
        int position = 1;
        while (position <= (k - 1)) {
            second = second.next;
            position++;
        }
        while (first != null && second.next != null) {
            first = first.next;
            second = second.next;
        }
        return first;
    }
}
