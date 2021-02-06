package array

fun main() {

    val input = intArrayOf(6,9,9)
    //test case passed for:
    //3,0,0,2,0,4
    //7,4,0,9
    //6,9,9

    var sum = 0

    val firstVal = input[0]

    for (index in 1 until input.size) {
        if (firstVal >= input[index]) {
            val diff = firstVal - input[index]
            sum += diff
        }
    }

    print(sum)
}