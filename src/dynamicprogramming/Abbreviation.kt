package dynamicprogramming

fun main() {
    //solving using 2 pointer approach...
    val firstStr = "AbcDE"
    val secondStr = "AFDE"

    val firstLength = firstStr.length
    val secondLength = secondStr.length

    var firstCounter = 0
    var secondCounter = 0

    var matchCount = 0

    while (firstCounter < firstLength && secondCounter < secondLength) {
        if (firstStr[firstCounter].toUpperCase() == secondStr[secondCounter]) {
            matchCount++
            secondCounter++
        }
        firstCounter++
    }

    if (matchCount == secondLength) println("YES") else println("NO")

}