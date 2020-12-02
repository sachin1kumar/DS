package array

import java.util.*
import java.util.PriorityQueue


fun main() {
    val input = intArrayOf(7, 10, 4, 3, 20, 15)
    val priorityQueue = PriorityQueue<Int>()

    //finding kth largest...
    val k = 3

    //It is using min heap approach with time complexity O(n)..
    // 7 10 4 3, then when the size of heap exceeds four then 3 will be removed and then 4 will be removed and
    // eventually it will return us 7 as it is top elemtn in the heap..
    // sequence will be:
    // 7
    // 7 10
    // 4 7 10
    // 3 4 7 10
    // 4 7 10
    // 4 7 10 20
    // 7 10 20
    // 7 10 15 20
    // 10 15 20
    // 15 20 -> 10 has got removed and printed outside the for loop..
    for (index in 0 until input.size) {
        priorityQueue.add(input[index])
        if (priorityQueue.size > k) {
            priorityQueue.remove()
        }
    }

    print(priorityQueue.remove())
    println()

    //for finding kth smallest in the array..
    smallest(input)
}

private fun smallest(input: IntArray) {
    var priorityQueue = PriorityQueue<Int>()
    val k = 5
    for (index in 0 until input.size) {
        priorityQueue.add(input[index])
        if (priorityQueue.size > k) {
            priorityQueue = removeLast(priorityQueue)
        }
    }
    println(priorityQueue.elementAt(priorityQueue.size - 1))
}

//For finding kth smallest remove the last element from queue.
private fun removeLast(pq: PriorityQueue<Int>): PriorityQueue<Int> {
    var pqnew = PriorityQueue<Int>()
    while (pq.size > 1) {
        pqnew.add(pq.poll())
    }
    pq.clear()
    return pqnew
}