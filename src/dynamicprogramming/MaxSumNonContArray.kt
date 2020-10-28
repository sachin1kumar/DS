package dynamicprogramming

fun main() {
    val input = intArrayOf(-2, 1, 3, -4, 5)

    //solving using DP

    val rowSize = 2
    val colSize = input.size

    val outputArr = Array(rowSize) { Array(colSize) { 0 } }

    for (j in 0 until colSize) {
        if (j == 0) {
            outputArr[0][0] = input[0]
            outputArr[1][0] = 0
        } else {
            outputArr[0][j] = input[j] + outputArr[1][j - 1]
            outputArr[1][j] = Math.max(outputArr[0][j - 1], outputArr[1][j - 1])
        }
    }

    println(Math.max(outputArr[0][colSize - 1], outputArr[1][colSize - 1]))
}