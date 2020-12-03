package array

fun main() {
    val input = intArrayOf(0, 2, 1, 2, 0)

    //Name of algorithm: Deutche National Flag Algorithm..
    var low = 0
    var mid = 0
    var high = input.size - 1

    while (mid <= high) {
        when (input[mid]) {
            0 -> {
                val temp = input[low]
                input[low] = input[mid]
                input[mid] = temp

                low++
                mid++
            }
            1 -> {
                mid++
            }
            2 -> {
                val temp = input[mid]
                input[mid] = input[high]
                input[high] = temp

                high--
            }
        }
    }

    //print output..
    for (element in input) {
        print("$element ")
    }
}