package dynamicprogramming

fun main() {
    val floorArray = intArrayOf(0, 1, 2)
    val eggArray = intArrayOf(0, 1, 2)

    System.out.println(getResult(floorArray, eggArray))
}

//calculate minimum number of dropping required in the worst case...
private fun getResult(floorArray: IntArray, eggArray: IntArray) : Int {
    //memoization matrix...
    //Note: Take floors as columns and eggs as row...
    val floorArrayLength = floorArray.size
    val eggArrayLength = eggArray.size
    val arr = Array(eggArrayLength) {Array(floorArrayLength) {0} }

    for (i in 0 until eggArrayLength) {
        for (j in 0 until floorArrayLength) {
            if (i == 0 || j == 0) {
                arr[i][j] = 0
            } else {
                //apply formula....
                //res = (1 + max( DP[i-1][j-1], DP[i][j-x] ))
                //x is the current floor here so taking x = j in the below code...
                arr[i][j] = (1 + Math.max(arr[i - 1][j - 1], arr[i][j - j]))
            }
        }
    }
    //return the last element in the matrix...
    return arr[floorArrayLength - 1][eggArrayLength - 1]
}