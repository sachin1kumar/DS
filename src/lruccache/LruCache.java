package lruccache;

import java.util.HashSet;

public class LruCache {
    //capacity of cache.
    private static final int capacity = 3;
    //current no. of pages which cache is currently holding.
    private static int currentCount = 0;
    private static DoublyLinkedList dummyHead;
    private static DoublyLinkedList dummyTail;
    //HashSet to avoid duplicates pages.
    private static HashSet<Integer> globalSet;
    //For holding the previous reference in the doubly linked list.
    private static DoublyLinkedList prevTemp = null;

    public static void main(String[] args) {
        dummyHead = createDummyHead();
        dummyTail = createDummyTail();
        operationsToPerform();
    }

    private static void operationsToPerform() {
        globalSet = new HashSet<>();
        insertPageToCache(1);
        insertPageToCache(2);
        insertPageToCache(3);
        insertPageToCache(4);
        insertPageToCache(1);
        insertPageToCache(2);
        insertPageToCache(5);
        insertPageToCache(1);
        insertPageToCache(2);
        insertPageToCache(3);
        insertPageToCache(4);
        insertPageToCache(5);
        printOutput();
    }

    private static void insertPageToCache(int page) {
        //To handle the case when currentCount of pages is less than capacity of cache and page is not present
        // in HashSet.
        if (!globalSet.contains(page) && currentCount < capacity) {
            globalSet.add(page);
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(page);

            if (currentCount == 0) {
                doublyLinkedList.prev = dummyHead;
                doublyLinkedList.next = dummyTail;
                dummyHead.next = doublyLinkedList;
                dummyTail.prev = doublyLinkedList;
            } else {
                dummyHead.next = doublyLinkedList;
                doublyLinkedList.next = prevTemp;
                doublyLinkedList.prev = dummyHead;
                prevTemp.prev = doublyLinkedList;
            }
            prevTemp = doublyLinkedList;
            currentCount++;
        }
        //To handle the case when page is not present in HashSet and currentCount of pages equals to capacity of cache
        // because we have taken currentCount equals to 0 initially. In this, we delete the least recently used page or we call it the last
        //node in the doubly linked list and insert the new one in the front.
        else if (!globalSet.contains(page) && currentCount == capacity) {
            DoublyLinkedList tailPrev = dummyTail.prev;
            globalSet.remove(tailPrev.data);
            dummyTail.prev = tailPrev.prev;
            tailPrev.prev.next = dummyTail;

            globalSet.add(page);
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(page);

            dummyHead.next = doublyLinkedList;
            doublyLinkedList.next = prevTemp;
            doublyLinkedList.prev = dummyHead;
            prevTemp.prev = doublyLinkedList;
            prevTemp = doublyLinkedList;
        }
        //To handle the case when page is present in HashSet, currentCount of pages equals to capacity of cache
        //because we have taken currentCount equals to 0 initially and in this we bring the requested page to the front
        //of doubly linked list. In this, we don't delete the least recently used page or the last node in doubly linked list
        // we simply bring the last one to the front.
        else {
            DoublyLinkedList tailPrev = dummyTail.prev;
            dummyTail.prev = tailPrev.prev;
            tailPrev.prev.next = dummyTail;

            dummyHead.next = tailPrev;
            tailPrev.next = prevTemp;
            tailPrev.prev = dummyHead;
            prevTemp.prev = tailPrev;
            prevTemp = tailPrev;
        }
    }


    private static DoublyLinkedList createDummyHead() {
        return new DoublyLinkedList(-1);
    }

    private static DoublyLinkedList createDummyTail() {
        return new DoublyLinkedList(-1);
    }

    private static void printOutput() {
        DoublyLinkedList iterator = dummyHead.next;
        while (iterator != dummyTail){
            System.out.print(iterator.data+" ");
            iterator = iterator.next;
        }
        System.out.println();
    }
}
