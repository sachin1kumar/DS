package array

fun main() {

    val arr = intArrayOf(2, 7, 9, 5, 8, 7, 4)
    val k = 5
    val lesserCount = getLesserCount(arr, k)

    //iterate using sliding window..
    var start = 0
    var end = lesserCount - 1

    var maxResult = 0

    while (end < arr.size) {
        var counter = 0
        for (index in start..end) {
            if (arr[index] > k) {
                counter++
            }
        }
        if (counter > maxResult) {
            maxResult = counter
        }
        start++
        end++
    }

    //print output..
    print(maxResult)

}

private fun getLesserCount(arr: IntArray, k: Int): Int {
    var count = 0
    for (element in arr) {
        if (element < k) {
            count++
        }
    }
    return count
}