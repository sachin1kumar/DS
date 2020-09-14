package priorityqueue

import java.util.ArrayList

fun main() {
   //Queue: 6, 8, 3, 10, 15, 2, 9
    val queue = intArrayOf(6, 8, 3, 10, 15, 2, 9).toList()

    val result = ArrayList<Int>()
    //1. Copy the elements from the queue.. Time complexity O(1) to inset a single element.
    for (element in queue) {
        result.add(element)
    }

    //2. To delete the elements, search for the smallest element.. Time complexity O(n) to delete a single element..
    var smallestElement = result[0]
    var deleteIndex = 0;
    for (index in 0 until result.size) {
        val element = result[index]
        if(element < smallestElement) {
            smallestElement = element
            deleteIndex = index
        }
    }

    //delete the element from list..
    result.removeAt(deleteIndex)

    //Print the updated result queue.
    for (index in 0 until result.size) {
        print("${result[index]} ")
    }
}