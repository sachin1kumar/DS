package linkedlist

fun main() {

    var firstNode = Node(1)
    var secondNode = Node(2)
    var thirdNode = Node(3)
    var fourthNode = Node(4)


    firstNode.next = secondNode
    secondNode.next = thirdNode
    thirdNode.next = fourthNode

    //print

    printMtd(insertNodeAtPosition(firstNode,122,2))

}

fun printMtd(llist: Node?){
    var head: Node? = llist
    while (head!=null){
        println(head.data)
        head = head.next
    }
}

fun insertNodeAtPosition(llist: Node?, data: Int, position: Int): Node? {

    if(position == -1){
        return llist
    }

    if(llist == null){
        return null
    }

    var pos = 0
    var pointer: Node? = llist
    var prev: Node? = null

    while(pos < position){
        prev = pointer
        pointer = pointer?.next
        pos++
    }

    val temp = pointer

    val newList = Node(data)
    prev?.next = newList
    //println(pointer.data)
    //println(temp?.data)

    newList?.next = temp
    //println(pointer?.next?.data)


    return llist

}
