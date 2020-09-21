package array

import java.util.*

fun main() {
    val arr = intArrayOf(2, 6, 3, 12, 56, 8)
    val k = 3 //each element is k distance away..

    //init priority queue..
    val priorityQueue = PriorityQueue<Int>()

    //init priority queue from k = 0 to 3..
    for (index in 0..k) {
        priorityQueue.add(arr[index])
    }

    //Remove or get the min. element from Priority queue.
    //And then add the elements.
    for (index in k + 1  until arr.size) {
        print("${priorityQueue.remove()} ")
        //now add..
        priorityQueue.add(arr[index])
    }

    //remove the left elements from priority queue as well..
    while (priorityQueue.size != 0) {
        print("${priorityQueue.remove()} ")
    }

}