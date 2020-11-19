package array

fun main() {
    val inputArray = intArrayOf(12, 11, -13, -5, 6, -7, 5, -3, -6)

    //We can solve using sorting algorithm but will take O(nlogn) time complexity..

    //we can also use the approach, keep on checking for the negative number and when encounter it save that number and we
    //have one variable for maintaing the index for shifting the number to a particular index and in this case it's 0 initially so shift it there
    //and shift all the preceding elements in the array to the next one index. But time complexity is O(n2)

    //Solving in O(n) using two pointer approach..
    var i = 0
    var j = inputArray.size - 1

    while (true) {
        //keep on incrementing i..
        while (i < j && inputArray[i] < 0) {
            i++
        }

        //Keep on decrementing j..
        while (i < j && inputArray[j] > 0) {
            j--
        }

        if (i < j) {
            //swap two numbers..
            val temp = inputArray[i]
            inputArray[i] = inputArray[j]
            inputArray[j] = temp
            i++
            j--
        } else {
            break
        }
    }

    //print output..
    for (element in inputArray) {
        print("$element ")
    }
    println()

    val inputArray2 = intArrayOf(12, 11, -13, -5, 6, -7, 5, -3, -6)
    separateMyCustomMethod(inputArray2)
}

private fun separateMyCustomMethod(input: IntArray) {
    var i = 0
    var j = input.size - 1

    while (i < j) {
        if (input[i] < 0 && input[j] > 0) {
            val temp = input[i]
            input[i] = input[j]
            input[j] = temp
            i++
            j--
        }
        if (input[i] > 0) {
            i++
        }

        if (input[j] < 0) {
            j--
        }
    }

    //print output..
    for (element in input) {
        print("$element ")
    }
    println()
    println(i)

    rearrange(input, i)

}

private fun rearrange(input: IntArray, splitIndex: Int) {
    var start = 0
    var splitIndex = splitIndex
    while (splitIndex < input.size) {
        val temp = input[start]
        input[start] = input[splitIndex]
        input[splitIndex] = temp
        splitIndex++
        start += 2
    }

    //print output..
    for (element in input) {
        print("$element ")
    }

}