package linkedlist;

public class RemoveString {

    private static LLChar head = null;
    private static LLChar slow = null;
    private static LLChar fast = null;
    private static LLChar curr = null;
    private static boolean isPresent = false;

    public static void main(String[] args) {
        head = initList();
        curr = head;


        checkAndIterate(curr,"bca");
        checkAndIterate(curr,"bca");

        iterate(head);
    }

    private static void checkAndIterate(LLChar curr, String str) {
        LLChar slow = curr;
        LLChar prev = null;
        StringBuilder stringBuilder = new StringBuilder("");

        while (curr != null){
            if(stringBuilder.length() != str.length()) {
                stringBuilder.append(curr.data);
            }
            else {
                if(stringBuilder.toString().equalsIgnoreCase(str)){
                    //isPresent = true;
                    if(slow != null) {
                        slow.next = prev;
                    }
                } else{
                    //isPresent = false;
                    slow = prev;
                    stringBuilder.delete(0,stringBuilder.length());
                    stringBuilder.append(curr.data);
                }
            }
            prev = curr;
            curr = curr.next;
        }
        System.out.println("SB:"+stringBuilder.toString());
    }

    private static LLChar initList(){
       /* LLChar head = new LLChar('a');
        LLChar two = new LLChar('b');
        LLChar three = new LLChar('c');
        LLChar four = new LLChar('b');
        LLChar five = new LLChar('c');
        LLChar six = new LLChar('a');
        LLChar seven = new LLChar('a');
        LLChar eight = new LLChar('b');
        LLChar nine = new LLChar('c');
        LLChar ten = new LLChar('a');
        LLChar eleven = new LLChar('b');*/

        LLChar head = new LLChar('a');
        LLChar two = new LLChar('b');
        LLChar three = new LLChar('b');
        LLChar four = new LLChar('b');
        LLChar five = new LLChar('b');
        LLChar six = new LLChar('b');
        LLChar seven = new LLChar('b');
        LLChar eight = new LLChar('b');
        LLChar nine = new LLChar('b');
        LLChar ten = new LLChar('a');
        LLChar eleven = new LLChar('b');

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

        return head;
    }

    private static void iterate(LLChar head){
        while (head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
}
