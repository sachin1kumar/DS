package array

fun main() {
    //1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9
    //1, 4, 3, 2, 6, 7
    val input = intArrayOf(1, 4, 3, 2, 6, 7)
    var index = 0
    var jumpCounter = 0

    while (index < input.size) {
        val sIndex = input[index]
        if (sIndex == 0) {
            break
        } else {
            index += sIndex
        }
        jumpCounter++

        if (index == input.size - 1) {
            jumpCounter--
        }
    }

    println(jumpCounter)
}