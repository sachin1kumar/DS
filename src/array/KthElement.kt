package array

import java.util.*

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
    // 15 20 -> 10 has hot removed and printed outside the for loop..
    for (index in 0 until input.size) {
        priorityQueue.add(input[index])
        if (priorityQueue.size > k) {
            priorityQueue.remove()
        }
    }

    print(priorityQueue.remove())
}