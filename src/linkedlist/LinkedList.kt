package linkedlist

fun main(args: Array<String>) {

    var firstNode = Node(1)
    var secondNode = Node(2)
    var thirdNode = Node(3)

    firstNode.next = secondNode
    secondNode.next = thirdNode

    var head: Node? = firstNode

    while (head!=null){
        println(head.data)
        head = head.next
    }

}