package linkedlist;

public class SeperateList {

    //code to print first odd list and then even one.

     //1 2 3 4 5 6 7 8 -1
    //private static LLJava head = null;
    private static LLJava head = null;

    private static LLJava current = null;
    private static LLJava prev = null;

    //private static LLJava prevO = head;
    //private static LLJava prevE = head;
    //private static LLJava tailO = null;

    public static void main(String[] args) {
        head = initList();
        iterate(head);

        current = head;
        prev = current;

        LLJava dummy = new LLJava();
        LLJava node = dummy;

        if(current.data % 2 != 0) {
            while (current != null) {
                if (current.data % 2 != 0) {
                    if (current != head) {
                        prev.next = current;
                    }
                    prev = current;
                } else {
                    node.next = current;
                    node = current;
                }
                current = current.next;
            }

            if (node != null) {
                node.next = null;
            }

            prev.next = dummy.next;
            iterate(head);
        } else {
            while (current != null) {
                if (current.data % 2 != 0) {
                    node.next = current;
                    node = current;
                } else {
                    if (current != head) {
                        prev.next = current;
                    }
                    prev = current;
                }
                current = current.next;
            }

            prev.next = null;

            node.next = head;
            iterate(dummy.next);
        }
    }


    private static LLJava initList(){
        LLJava head = new LLJava(1);
        LLJava two = new LLJava(2);
        LLJava three = new LLJava(3);
        LLJava four = new LLJava(4);
        LLJava five = new LLJava(5);
        LLJava six = new LLJava(6);
        LLJava seven = new LLJava(7);
        LLJava eight = new LLJava(8);

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

    private static void iterate(LLJava head){
        while (head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }

}


