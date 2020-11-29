package array

fun main() {
    //Rearrange array such that even positioned are greater than odd..
    //such that A[i] >= A[i - 1]

    //input
    //3, 4, 5, 6, 7, 1, 2
    //1, 2, 2, 1
    //4, 3, 5, 6, 7, 1, 2
    val arr = intArrayOf(4, 3, 5, 6, 7, 1, 2)

    for (index in 1 until arr.size) {
        if (arr[index] <= arr[index - 1]) {
            val lastIndex = index - 1
            if (lastIndex <= arr.size - 1) {
                //swap the two elements..
                val temp = arr[index]
                arr[index] = arr[lastIndex]
                arr[lastIndex] = temp
            }
        }
    }

    //print output..
    for (element in arr) {
        print("$element ")
    }
}

