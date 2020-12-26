package array

fun main() {

    val input = intArrayOf(2, 3, 4, 5, -1, 0)
    //input:
    //6, -3, -10, 0, 2 passed.
    //2, 3, 4, 5, -1, 0 passed.

    var maxProd = input[0]
    var currProd = 1

    for (index in 0 until input.size) {
        currProd *= input[index]

        if (currProd > maxProd) {
            maxProd = currProd
        }
    }

    println(maxProd)
}