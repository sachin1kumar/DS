package array

fun main() {
    val inputArray = intArrayOf(12, 11, -13, -5, 6, -7, 5, -3, -6)

    //Can we solve using sorting algorithm but will take O(nlogn) time complexity..

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

}