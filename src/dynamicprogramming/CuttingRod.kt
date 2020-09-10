package dynamicprogramming

fun main() {
    val pieceLength = 5 //including hypothetical 0 index as well
    val totalLength = 6 //including hypothetical 0 index as well

    //profit array
    val profitArray = intArrayOf(0, 2, 5, 9, 6) //including hypothetical 0 index as well

    //creating piece array..
    val pieceArray = IntArray(pieceLength)
    for (index in 0 until pieceLength) {
        pieceArray[index] = index
    }

    //creating total length array..
    val totalLengthArray = IntArray(totalLength)
    for (index in 0 until totalLength) {
        totalLengthArray[index] = index
    }

    System.out.println(getMaxProfit(profitArray, pieceArray, totalLengthArray, pieceLength, totalLength))
}

fun getMaxProfit(profitArray : IntArray, pieceArray: IntArray, totalLengthArray: IntArray, pieceLength: Int, totalLength: Int) : Int {
    //Creating memoization matrix...
    val arr = Array(pieceLength) {Array(totalLength) {0} }

    for (i in 0 until pieceLength) {
        for (j in 0 until totalLength) {
            if (i == 0 || j == 0) {
                arr[i][j] = 0
            } else if (pieceArray[i] > totalLengthArray[j]) {
                arr[i][j] = arr[i - 1][j]
            } else if (pieceArray[i] <= totalLengthArray[j]) {
                val ri = totalLengthArray[j] - pieceArray[i]
                arr[i][j] = Math.max(arr[i - 1][j], profitArray[i] + arr[i][ri])
            }
        }
    }

    return arr[pieceLength - 1][totalLength - 1]
}

