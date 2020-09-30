package array

fun main() {
    val arr = intArrayOf(5, 6, 7, 8, 9, 10, 1, 2, 3)

    val searchElement = 2

    //get the index of the searchElement using binary search..
    val index = searchForElement(arr, searchElement)

    print(index)
}

fun searchForElement(arr: IntArray, searchElement: Int) : Int {
    val left = 0
    val right = arr.size - 1

    val mid = (left + right) / 2

    val leftElement = arr[left]
    val rightElement = arr[mid]

    var result = -1

    result = if (searchElement in leftElement..rightElement) {
        binarySearchImp(arr, left, mid, searchElement)
    } else {
        binarySearchImp(arr, mid + 1, right, searchElement)
    }
    return result
}

fun binarySearchImp(arr: IntArray, left: Int, right: Int, searchElement: Int): Int {
    var mLeft = left
    var mRight = right
    var index = -1

    while (mLeft <= mRight) {
        val mid = (mLeft + mRight) / 2
        if (arr[mid] == searchElement) {
            index = mid
            break
        } else if (searchElement < arr[mid]) {
            mRight = mid - 1
        } else {
            mLeft = mid + 1
        }
    }
    return index
}
