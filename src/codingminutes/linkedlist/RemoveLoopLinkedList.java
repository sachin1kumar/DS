package codingminutes.linkedlist;

public class RemoveLoopLinkedList {

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
        list7.next = list2;

        printList(removeLoopOrCycle(head));
    }

    private static LinkedList getStartingNodeInLoop(LinkedList head) {
        LinkedList intersectingNode = checkForLoopOrCycleInTheList(head);
        LinkedList slow = head;
        LinkedList fast = intersectingNode;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        if (slow == fast) {
            return slow;
        }
        return null;
    }
    private static LinkedList checkForLoopOrCycleInTheList(LinkedList head) {
        if (head == null || head.next == null) {
            return null;
        }
        LinkedList slow = head;
        LinkedList fast = head;

        while (slow != null && fast !=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

    private static LinkedList removeLoopOrCycle(LinkedList head) {
        if (head == null) {
            return null;
        }

        LinkedList startingNode = getStartingNodeInLoop(head);
        LinkedList temp = startingNode;

        while (temp != null && temp.next != startingNode) {
            temp = temp.next;
        }

        if (temp != null) {
            temp.next = null;
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
