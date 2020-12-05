package array

var minVal = 0
var maxVal = 0

fun main() {

    //In O(n) time complexity. Space complexity O(1)..

    val input = intArrayOf(3, 9, 12, 16, 20)
    val k = 3

    modifyArray(input, k, 0)

    var maxResult = 0

    for (index in 1 until input.size) {
        modifyArray(input, k, index)
        //logic for calculating max. diff..

        if (input[index] <= minVal) {
            minVal = input[index]
        }

        if (input[index] >= maxVal) {
            maxVal = input[index]
        }

        val diff = maxVal - minVal

        if (diff > maxResult) {
            maxResult = diff
        }

    }

    println(maxResult)

    //iterate and print input array...
    for (index in 0 until input.size) {
        print("${input[index]} ")
    }
}

private fun modifyArray(input: IntArray, k: Int, index: Int) {
    val diff1 = input[index] - k
    var diff2 = 0
    if (diff1 < 0) {
        diff2 = input[index] + k
        input[index] = diff2
    } else {
        input[index] = diff1
    }
    if (index == 0) {
        minVal = input[index]
        maxVal = input[index]
    }
}