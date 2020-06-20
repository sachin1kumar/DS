package linkedlist;

public class AppendNodes {

    private static int m = 1;
    private static int n = 1;
    private static int sum = 0;
    private static LLJava curr = null;

    //
    private static int M = 3;
    private static int N = 2;

    public static void main(String[] args) {
        LLJava head = initList();
        iterate(head);
        if(head == null){
            return;
        }

        if(N==0 && M==0){
            return;
        }

        if(N==0){
            return;
        }

        curr = head;

        while(curr != null){
            if(m > M && n <= N){
                sum += curr.data;
                if(n == N){
                    modify();
                    continue;
                } else{
                    n++;
                }
            }
            m++;
            curr = curr.next;
        }

        iterate(head);
    }

    private static void modify() {
        LLJava temp = null;
        LLJava dummy = new LLJava(sum);
        temp = curr.next;
        curr.next = dummy;
        dummy.next = temp;
        curr = dummy.next;
        m = 1;
        n = 1;
        sum = 0;
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
        LLJava nine = new LLJava(9);
        LLJava ten = new LLJava(10);
        LLJava eleven = new LLJava(11);
        LLJava twelve = new LLJava(12);
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
        eight.next = nine;
        nine.next = ten;
        ten.next = eleven;
        eleven.next = twelve;
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
