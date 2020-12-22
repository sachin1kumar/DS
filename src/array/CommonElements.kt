package array

fun main() {

    val firstArray = intArrayOf(1, 5, 10, 20, 40, 80)
    val secondArray = intArrayOf(6, 7, 20, 80, 100)
    val thirdArray = intArrayOf(3, 4, 15, 20, 30, 70, 80, 120)

    var firstIndex = 0

    while (firstIndex < firstArray.size) {
        val currentElement = firstArray[firstIndex]
        var secondIndex = 0
        var isPresentInSecond = false

        if (currentElement > secondArray[secondIndex]) {
            while (secondIndex < secondArray.size) {
                if (currentElement == secondArray[secondIndex]) {
                    isPresentInSecond = true
                    break
                }
                secondIndex++
            }
        }

        var thirdIndex = 0
        var isPresentInThird = false

        if (currentElement > thirdArray[thirdIndex]) {
            while (thirdIndex < thirdArray.size) {
                if (currentElement == thirdArray[thirdIndex]) {
                    isPresentInThird = true
                    break
                }
                thirdIndex++
            }
        }

        if (isPresentInSecond && isPresentInThird) {
            print("$currentElement ")
        }

        firstIndex++
    }
}