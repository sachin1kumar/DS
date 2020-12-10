package array

fun main() {

    val arr1 = intArrayOf(1, 4, 7, 8, 10)
    val arr2 = intArrayOf(2, 3, 9)

    var gapIndex = getGapIndex(arr1.size, arr2.size)
    var fistIndex = 0
    var lastIndex = gapIndex

    if (gapIndex > arr1.size) {
        lastIndex = gapIndex
    }

    while (gapIndex != 1) {
        while (lastIndex < arr2.size) {

        }
        if (lastIndex > arr1.size || lastIndex > arr2.size) {
            fistIndex = 0
            lastIndex = fistIndex + gapIndex
        }
        gapIndex = getGapIndex(arr1.size, arr2.size)
    }

}

fun getGapIndex(firstSize:Int, secondSize: Int) : Int {
    val totalSize = firstSize + secondSize
    var gapIndex = totalSize / 2
    if (totalSize % 2 != 0) {
        gapIndex++
    }
    return gapIndex
}