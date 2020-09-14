package priorityqueue

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    //Queue: 6, 8, 3, 10, 15, 2, 9
    val queue = intArrayOf(6, 8, 3, 10, 15, 2, 9)

    //Converting to AL for easy deletion without shifting..
    val list = ArrayList<Int>()
    for (index in queue.indices) {
        list.add(queue[index])
    }

    //1. Sort the queue, in increasing order. Time complexity O(nlogn)
    list.sort()

    //2. Delete the element from the first index.. Time complexity O(1)..
    list.removeAt(0)
    //print the updated list
    for (index in list.indices) {
        print("${list[index]} ")
    }
}