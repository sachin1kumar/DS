package queue

class Queue {

    //Here, we are considering size is pre-defined.
    var size = 5

    var elements = IntArray(size)
    var fIndex = -1
    var nextIndex = 0


    fun insert(element: Int) {
        if (nextIndex == size) {
            nextIndex = 0
        } else if (fIndex == size) {
            fIndex = 1
        }
        elements[nextIndex] = element
        nextIndex++
        fIndex=0
    }

    fun size() : Int {
        return size
    }

    fun isEmpty() : Boolean {
        if (size == 0){
            return true
        }
        return false
    }

    fun front() : Int {
        return elements[fIndex]
    }

    fun dequeue() : Int {
        return 0
    }
}

fun main() {
    var queue = Queue()
    queue.insert(1)
    queue.insert(2)
    queue.insert(3)
    queue.insert(4)
    queue.insert(5)
    queue.insert(6)
    /*queue.insert(7)
    queue.insert(8)
    queue.insert(9)
    queue.insert(10)
    queue.insert(11)*/


    for (element in queue.elements){
        println(element)
    }

    println("---front element--")
    println(queue.front())
}