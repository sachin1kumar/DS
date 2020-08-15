package lrucache;

public class DoublyLinkedList {

    public int data;
    public DoublyLinkedList prev;
    public DoublyLinkedList next;

    public DoublyLinkedList(int data){
        this.data = data;
        prev = null;
        next = null;
    }
}
