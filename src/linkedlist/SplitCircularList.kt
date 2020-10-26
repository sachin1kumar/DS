package linkedlist

fun main() {
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)

    val node5 = Node(5)


    val head = node1

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node1


    //count the total no. of nodes...
    val totalCount = getTotalCount(head)
    print(totalCount)

    //Get the head1..
    getFirstList(totalCount, head)
}

fun getTotalCount(head: Node): Int {
    var slow = head
    var fast = head
    var count = 0

    while (slow.next != null && fast.next != null) {
        slow = slow.next!!
        fast = fast.next?.next!!
        count++
        if (slow == fast) {
            break
        }
    }
    return count
}

fun getFirstList(totalCount: Int, head: Node) {
    val divisibleCount = totalCount
    var firstDivisibleCount = 0
    var secondDivisibleCount = 0

    if (divisibleCount % 2 != 0) {
        firstDivisibleCount = (divisibleCount / 2) + 1
    } else {
        firstDivisibleCount = (divisibleCount / 2)
    }

    secondDivisibleCount = divisibleCount - firstDivisibleCount

    //Run the loop till firstDivisibleCount..
    var firstCounter = 0
    var head1 = head
    var prev1: Node? = null
    while (firstCounter != firstDivisibleCount) {
        prev1 = head1
        head1 = head1.next!!
        firstCounter++
    }

    prev1?.next = null

    //second list head..
    val head2 = head1

    var secondCounter = 0
    var tempHead2 = head2
    var prev2: Node? = null
    while (secondCounter != secondDivisibleCount) {
        prev2 = tempHead2
        tempHead2 = tempHead2.next!!
        secondCounter++
    }

    prev2?.next = null

    //print head1.
    println()
    var tHead1: Node? = head
    while (tHead1 != null) {
        print("${tHead1.data} ")
        tHead1 = tHead1.next
    }
    println()
    //print head2..
    var tHead2: Node? = head2
    while (tHead2 != null) {
        print("${tHead2.data} ")
        tHead2 = tHead2.next
    }
}