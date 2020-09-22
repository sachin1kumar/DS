package array

var count = 0

fun main() {
    val arr = intArrayOf(1, 0, 0, 1, 0, 1, 1)

    for (fIndex in 0 until arr.size) {
        for (sIndex in fIndex + 1 until arr.size) {
            getCount(fIndex, sIndex, arr)
        }
    }

    println(count)

    //optimised solution..
    print(getCountOpt(arr))
}

private fun getCount(start: Int, end: Int, arr: IntArray) : Int {
    var zeroCount = 0
    var oneCount = 0

    for (index in start..end) {
        if (arr[index] == 0) {
            zeroCount++
        }
        if (arr[index] == 1) {
            oneCount++
        }
    }

    if (zeroCount == oneCount) {
        count++
    }
    return count
}

//optimised solution..
private fun getCountOpt(arr: IntArray) : Int {
    val map = HashMap<Int, Int>()
    map[0] = -1

    var sum = 0
    var count = 0

    for (index in 0 until arr.size) {
        if (arr[index] == 0) {
            sum += -1
        } else {
            sum += 0
        }
        if (map.containsKey(sum)) {
            count++
        } else {
            map[sum] = index
        }
    }
    return count
}