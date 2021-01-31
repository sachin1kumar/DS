package array

fun main() {

    val inputArray = intArrayOf(90, 80, 70, 60, 50)
    //input1 100, 30, 15, 10, 8, 25, 80 passed.
    //input2 10, 22, 5, 75, 65, 80 passed.
    //input3 90, 80, 70, 60, 50 passed.
    var maxProfit = 0
    val lastIndex = inputArray.size - 1

    for (index in 0 until lastIndex) {
        val buyPrice = inputArray[index]
        val sellPrice = inputArray[index + 1]
        if(buyPrice <= sellPrice) {
            val diff = sellPrice - buyPrice
            maxProfit += diff
        }
    }

    print("max profit: $maxProfit")
}