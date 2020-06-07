package linkedlist;

public class DivideLinkedList {

    /*
    * Divide linked list in two
Level MEDIUM
Write a function that takes one list and divides up its nodes to create two smaller lists A and B. The sub lists should be made from alternating elements in the original list.
Nodes should be in the reverse order of which they occurred in the source list.
Print both linked lists in different lines.*/

    public static void main(String[] args) {

        LLJava head = initList();
        LLJava slow = head;
        LLJava fast = head.next;

        LLJava N1 = slow;
        LLJava N2 = fast;

        while (slow != null && fast != null) {
            if (fast != null) {
                slow.next = fast.next;
                slow = fast.next;
            }

            if (slow != null){
                fast.next = slow.next;
                fast = slow.next;
            }
        }

        iterate(N1);
        iterate(N2);

        LLJava list1 = reverse(N1);
        LLJava list2 = reverse(N2);

        iterate(list1);
        iterate(list2);
    }

    private static LLJava reverse(LLJava head){
        if(head == null){
            return null;
        }

        LLJava curr = head;
        LLJava prev = null;
        LLJava temp;

        while (curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }


    private static void iterate(LLJava head){
        while (head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }

    private static LLJava initList(){
        LLJava head = new LLJava(8);
        LLJava two = new LLJava(2);
        LLJava three = new LLJava(5);
        LLJava four = new LLJava(9);
        LLJava five = new LLJava(1);
        LLJava six = new LLJava(4);
        LLJava seven = new LLJava(3);
        LLJava eight = new LLJava(7);

        /*LLJava head = new LLJava(8);
        LLJava two = new LLJava(7);
        LLJava three = new LLJava(6);
        LLJava four = new LLJava(5);
        LLJava five = new LLJava(4);
        LLJava six = new LLJava(3);
        LLJava seven = new LLJava(2);
        LLJava eight = new LLJava(1);*/

        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;

        return head;
    }
}
