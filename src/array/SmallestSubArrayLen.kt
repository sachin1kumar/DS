package array

fun main() {

    val arr = intArrayOf(1, 10, 5, 2, 7)
    val x = 9
    //passed test cases:
    //1, 4, 45, 6, 0, 19 x=51
    //1, 10, 5, 2, 7 x=9

    var min = arr.size

    var start = 0
    var end = 0

    while (end < arr.size) {
        var sum = 0
        for (index in start..end) {
            sum += arr[index]
            if (end - start < min && sum > x) {
                min = (end - start) + 1
                start++
                end = start
            }
        }
        end++
    }

    print(min)
}