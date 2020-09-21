package array

import java.util.*

fun main() {

    //3 x 3 matrix...
    val arr = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))

    //taking k = 3
    val k = 3

    //init priority queue..
    val priorityQueue = PriorityQueue<Int>()

    for (index in 0 until k) {
        priorityQueue.add(arr[0][index])
    }

    for (row in 1 until k) {
        for (col in 0 until k) {
            print("${priorityQueue.remove()} ")
            priorityQueue.add(arr[row][col])
        }
    }

    //remove left elements in priority queue..
    while (priorityQueue.size != 0) {
        print("${priorityQueue.remove()} ")
    }

}