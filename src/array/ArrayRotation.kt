package array

fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    //create temp. Array..
    val tempArray = createTemArray(arr, 2)
    val result = rotateArray(tempArray, arr, 2)
    //Print result
    printResult(result)
}

private fun rotateArray(tempArray: ArrayList<Int>, array: IntArray, d:Int): IntArray {
    var gIndex = 0
    for (index in array.indices) {
        if (index < (array.size - d)) {
            array[index] = array[index + 2]
        } else {
            array[index] = tempArray[gIndex]
            gIndex++
        }
    }
    return array
}

private fun createTemArray(array: IntArray, d: Int): ArrayList<Int> {
    val tempArray = ArrayList<Int>()
    for (index in 0 until d) {
        tempArray.add(array[index])
    }
    return tempArray
}

private fun printResult(result: IntArray) {
    for (index in result.indices) {
        print("${result[index]} ")
    }
}