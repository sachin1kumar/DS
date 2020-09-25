package array

import tree.takeInputLevelwise

//Brute force solution. O(n2)
//optimised solution. O(n)
fun main() {
    bruteForceSolution()
    optimisedSolution()
}

fun optimisedSolution() {
    val input = intArrayOf(8, 3, 1, 2)

    //convert the arr to AL.
    val inputList = ArrayList<Int>()
    var sum = 0
    for (index in 0 until inputList.size) {
        inputList.add(input[index])
        sum += index * inputList[index]
    }

    var max = Int.MIN_VALUE

    if (sum > max) {
        max = sum
    }

    //run the loop until N-1 for N size array. So, performing N-1 rotations..
    for (index in 0 until inputList.size - 1) {
        val firstElement = inputList[0]
        inputList.removeAt(0)
        inputList.add(firstElement)
        sum += index * inputList[index]
        if (sum > max) {
            max = sum
        }
    }

    print("Max: $max")
}

private fun bruteForceSolution() {
    val input = intArrayOf(8, 3, 1, 2)
    var shiftedArray = shiftElement(input)
    var max = Int.MIN_VALUE

    while (isEqual(shiftedArray, input)) {
        val sum = calculateSum(shiftedArray)
        if (sum > max) {
            max = sum
        }
        shiftedArray = shiftElement(shiftedArray)
    }

    val sumN =  calculateSum(shiftedArray)
    if (sumN > max) {
        max = sumN
    }

    print("Max sum: $max")
}

private fun isEqual(originalArray: IntArray, arr: IntArray) : Boolean {
    for (index in originalArray.indices) {
        if (originalArray[index] != arr[index]) {
            return false
        }
    }
    return true
}

private fun shiftElement(arr: IntArray) : IntArray {
    val elementAtFirstIndex = arr[0]
    val modifiedArr = IntArray(arr.size)

    for (index in 0 until arr.size - 1) {
        modifiedArr[index] = arr[index + 1]
    }
    //add 0th element to the last index...
    modifiedArr[arr.size - 1] = elementAtFirstIndex
    return modifiedArr
}

private fun calculateSum(arr: IntArray) : Int {
    var sum = 0

    for (index in arr.indices) {
        val prod = index * arr[index]
        sum += prod
    }
    return sum
}
