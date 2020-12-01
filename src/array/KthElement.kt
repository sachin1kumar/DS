package array

import java.util.*

fun main() {
    val input = intArrayOf(7, 10, 4, 3, 20, 15)
    val priorityQueue = PriorityQueue<Int>()

    //finding kth largest...
    val k = 4

    for (index in 0 until input.size) {
        priorityQueue.add(input[index])
        if (priorityQueue.size > k) {
            priorityQueue.remove()
        }
    }

    print(priorityQueue.remove())
}