package array

import java.util.*

fun main() {
    val inputArray1 = intArrayOf(11, 1, 13, 21, 3, 7)
    val inputArray2 = intArrayOf(11, 3, 7, 1)

    //Sorting the above arrays using java util TimSort Algo.
    //Sorting time complexity: O(nlogn)

    Arrays.sort(inputArray1)
    Arrays.sort(inputArray2)

    //Iterate on the above sorted arrays..
    var firstArrIndex = 0
    var secondArrIndex = 0

    while (firstArrIndex < inputArray1.size && secondArrIndex < inputArray2.size) {
        if (inputArray1[firstArrIndex] != inputArray2[secondArrIndex]) {
          print("No")
          break;
        }
        firstArrIndex++
        secondArrIndex++
    }

    if (secondArrIndex == inputArray2.size) {
        print("Yes")
    }
}