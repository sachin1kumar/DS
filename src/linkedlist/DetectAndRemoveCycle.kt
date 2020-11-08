package linkedlist

fun main() {

    //create linked list..
    val head = Node(1)
    val secondNode = Node(2)
    val thirdNode = Node(3)
    val fourthNode = Node(4)
    val fifthNode = Node(5)

    head.next = secondNode
    secondNode.next = thirdNode
    thirdNode.next = fourthNode
    fourthNode.next = fifthNode
    fifthNode.next = thirdNode


    //Detect loop..
    var slow: Node? = head
    var fast: Node? = head

    while (slow != null && fast != null) {
        slow = slow.next
        fast = fast.next?.next

        if (slow == fast) {
            break
        }
    }

    if (slow != fast) {
        print("No loop detected")
    }

    //shift slow to head..
    slow = head

    while (slow?.next != fast?.next) {
        slow = slow?.next
        fast = fast?.next
    }

    fast?.next = null

    var tempHead: Node? = head

    while (tempHead != null) {
        print("${tempHead.data} ")
        tempHead = tempHead.next
    }
}