package codingminutes.linkedlist;

public class Sort012LinkedList {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(1);
        LinkedList head = list1;
        LinkedList list2 = new LinkedList(0);
        LinkedList list3 = new LinkedList(2);
        LinkedList list4 = new LinkedList(1);
        LinkedList list5 = new LinkedList(1);
        LinkedList list6 = new LinkedList(0);
        LinkedList list7 = new LinkedList(2);

        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
        list5.next = list6;
        list6.next = list7;

       // printList(naiveApproach(head));
        printList(optimizedApproach(head));
    }

    /*
     * TC = O(n) -> double traversal of list with data replacement.
     * SC = O(1)
     * */
    private static LinkedList naiveApproach(LinkedList head) {
        if (head == null || head.next == null) {
            return head;
        }
        //count number of 0, 1, 2
        int noOfZero = 0;
        int noOfOne = 0;
        int noOfTwo = 0;
        LinkedList temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                noOfZero++;
            } else if (temp.data == 1) {
                noOfOne++;
            } else {
                noOfTwo++;
            }
            temp = temp.next;
        }
        temp = head;
        while (temp != null && noOfZero >= 1) {
            temp.data = 0;
            noOfZero--;
            temp = temp.next;
        }
        while (temp != null && noOfOne >= 1) {
            temp.data = 1;
            noOfOne--;
            temp = temp.next;
        }
        while (temp != null && noOfTwo >= 1) {
            temp.data = 2;
            noOfTwo--;
            temp = temp.next;
        }
        return head;
    }

    /*
     * TC = O(n)
     * SC = O(1)
     * */
    private static LinkedList optimizedApproach(LinkedList head) {
        if (head == null || head.next == null) {
            return head;
        }
        //create 0 , 1 and 2 lists.
        LinkedList zeroHead = new LinkedList(-1);
        LinkedList zeroTail = zeroHead;

        LinkedList oneHead = new LinkedList(-1);
        LinkedList oneTail = oneHead;

        LinkedList twoHead = new LinkedList(-1);
        LinkedList twoTail = twoHead;

        LinkedList curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                zeroTail.next = curr;
                zeroTail = curr;
            } else if (curr.data == 1) {
                oneTail.next = curr;
                oneTail = curr;
            } else {
                twoTail.next = curr;
                twoTail = curr;
            }
            curr = curr.next;
        }
        //merge three lists
        zeroTail.next = oneHead.next;
        oneTail.next = twoHead.next;
        twoTail.next = null;

        return zeroHead.next;
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
