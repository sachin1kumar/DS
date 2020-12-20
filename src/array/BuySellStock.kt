package array

fun main() {
    //7,1,5,3,6,4 -> passed.
    //7,6,4,3,1 -> passed.
    val prices = intArrayOf(7,1,5,3,6,4)
    //smallest 7 1

    //diff  = curr - smallest =   -6 4 2 5 3

    val len = prices.size
    if(len == 0 || len == 1) {
        return
    }

    var smallest = prices[0]
    var diff = 0
    var result = -1

    for (index in 1 until len) {
        val current = prices[index]
        if (current < smallest) {
            smallest = current
        }
        diff = current - smallest
        if (diff > result) {
            result = diff
        }
    }

    println(result)
}