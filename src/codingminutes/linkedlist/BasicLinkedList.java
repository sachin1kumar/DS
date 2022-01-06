package codingminutes.linkedlist;

public class BasicLinkedList {

    private static LinkedList head = null;

    public static void main(String[] args) {

        LinkedList updatedHead = insertAtHead(1);
        LinkedList updatedHead_ = insertAtHead(2);
        printList(updatedHead_);
        System.out.println("Insert the element");
        LinkedList updatedHead2 = insertAtPos(updatedHead_, 3, 1);
        printList(updatedHead2);
    }

    private static LinkedList insertAtHead(int data) {
        if (head == null) {
            head = new LinkedList(data);
            return head;
        }

        final LinkedList newList = new LinkedList(data);
        newList.next = head;
        head = newList;
        return head;
    }

    private static void printList(LinkedList head) {
        if (head == null) {
            System.out.println("Empty List");
        }
        LinkedList temp = head;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static LinkedList insertAtPos(LinkedList head, int data, int pos) {
        // 0 1 2
        if (head != null && pos < 0) {
            System.out.println("Pos is invalid");
            return head;
        }

        if (head == null && pos < 0) {
            System.out.println("Current list is empty and pos passed is invalid.");
            return null;
        }

        if (head == null && pos > 0) {
            System.out.println("Current list is empty and pos passed is greater than 0.");
            return null;
        }

        int currentPos = 0;
        LinkedList temp = head;
        LinkedList prev = null;

        while (temp != null && currentPos != pos) {
            currentPos += 1;
            prev = temp;
            temp = temp.next;
        }

        if (prev != null) {
            LinkedList newList = new LinkedList(data);
            LinkedList temp_ = prev.next;
            prev.next = newList;
            newList.next = temp_;
        } else {
            LinkedList newList = new LinkedList(data);
            newList.next = head;
            head = newList;
        }
        return head;
    }
}
