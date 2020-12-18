package array

fun main() {

    //2, 4, 1, 3, 5 -> passed
    //2, 3, 4, 5, 6 -> passed
    //10, 10, 10 -> passed

    //Time complexity O(n)
    //Space complexity O(1)
    val input = intArrayOf(10, 10, 10)

    var element1 = 0
    var element2 = 0
    var startIndex = 0
    var inversionCount = 0
    val arraySize = input.size

    if (arraySize == 0 || arraySize == 1) {
        println(0)
    }

    if (arraySize > 1) {
        element1 = input[0]
        element2 = input[1]
    }

    if (arraySize == 2) {
        if (element1 > element2) {
            println(1)
        } else {
            println(0)
        }
    }

    if (arraySize > 2) {
        startIndex = 2
        for (index in startIndex until arraySize) {
            if (element1 > input[index] && element2 > input[index]) {
                inversionCount += 2
            } else {
                if (element1 > input[index]) {
                    inversionCount++
                }
                if (element2 > input[index]) {
                    inversionCount++
                }
            }

            if (input[index] > element1) {
                element1 = input[index]
            }
            if (input[index] > element2) {
                element2 = input[index]
            }
        }
    }

    //print output..
    println(inversionCount)
}