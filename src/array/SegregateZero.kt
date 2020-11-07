package array

fun main() {
    val arr = intArrayOf(0, 1, 0, 1, 0, 0, 1, 1, 1)

    //count no. of zero..
    var zeroCount = 0

    for (index in 0 until arr.size) {
        if (arr[index] == 0) {
            zeroCount++
        }
    }

    //update first zeroCount in array with zero.
    for (index in 0 until zeroCount) {
        arr[index] = 0
    }

    //rest with one..
    for (index in (arr.size - zeroCount)-1 until arr.size) {
        arr[index] = 1
    }

    //print output..
    for (index in 0 until arr.size) {
        print("${arr[index]} ")
    }
}