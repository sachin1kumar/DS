package codingminutes.linkedlist;

public class BasicLinkedList {

    private static LinkedList head = null;

    public static void main(String[] args) {

        LinkedList updatedHead = insertAtHead(1);
        LinkedList updatedHead_ = insertAtHead(2);
        printList(updatedHead_);
    }

    private static LinkedList insertAtHead(int data) {
        if (head == null) {
            head = new LinkedList(data);
            return head;
        }

        LinkedList newList = new LinkedList(data);
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


}
