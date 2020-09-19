package sorting


val inputArr = intArrayOf(3, 5, 1, 2, 7, 8, 4).asList()
val inputArray = ArrayList<Int>(inputArr)
var size = 1000

//ArrayList to store output sorted elements...
val output = ArrayList<Int>()

fun main() {
    while (size != 0) {
        size = inputArr.size
        //keep heapifying the tree..
        heapifyTree(inputArray)
    }
    //print output...
    for (index in 0 until output.size) {
        print("${output.get(index)} ")
    }
}

private fun heapifyTree(inputArray: ArrayList<Int>) {
    for (index in (size / 2) - 1 downTo 0 step 1) {
        heapify(inputArray, index)
    }
    output.add(inputArray[0])
    //replace the first element in inputArray with the last element...
    inputArray.removeAt(0)
    var updatedSize = inputArray.size
    val lastElement = inputArray[updatedSize - 1]
    inputArray.add(0, lastElement)
    //remove the last element..
    updatedSize = inputArray.size
    inputArray.removeAt(updatedSize - 1)
    size = inputArray.size
}

private fun heapify(inputArray: ArrayList<Int>, index: Int) {
    val left = 2 * index + 1
    val right = 2 * index + 2

    //find min. index..
    var leftMin = -1
    var rightMin = -1
    var minIndex = -1
    if (left <= size - 1) {
        leftMin = getMinLeftIndex(inputArray, index, left)
    }
    if (right <= size - 1) {
        rightMin = getMinRightIndex(inputArray, index, right)
    }

    if (leftMin <= rightMin) {
        minIndex = leftMin
    } else {
        minIndex = rightMin
    }

    for (index in 0 until inputArray.size) {
        if (minIndex == inputArray[index]) {
            minIndex = index
        }
    }

    if (minIndex != index) {
        val temp = inputArray[index]
        inputArray[index] = inputArray[minIndex]
        inputArray[minIndex] = temp
    }
}

private fun getMinLeftIndex(inputArray: ArrayList<Int>, index : Int, left: Int): Int {
    if(inputArray[index] <= inputArray[left]) {
        return inputArray[index]
    }
    return inputArray[left]
}

private fun getMinRightIndex(inputArray: ArrayList<Int>, index : Int, right: Int): Int {
    if(inputArray[index] <= inputArray[right]) {
        return inputArray[index]
    }
    return inputArray[right]
}

