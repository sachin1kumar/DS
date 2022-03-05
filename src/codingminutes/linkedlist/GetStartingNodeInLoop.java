package codingminutes.linkedlist;

public class GetStartingNodeInLoop {

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
        //Output should be 2
        //1. Find intersecting node in the loop where we have slow and fast at the same node.
        //2. Assign slow = head and increment both slow and fast till both reach at the same node and that will be
        //our output which is the starting node in the loop.
        LinkedList output = getStartingNodeInLoop(head);
        if (output != null) {
            System.out.println(output.data);
        }
    }

    private static LinkedList getStartingNodeInLoop(LinkedList head) {
        //follow the above steps.
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
}
