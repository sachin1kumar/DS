package test

fun main() {
    //conversion from int to string..
    val ints = intArrayOf(1, 2, 3, 4)
    val strings = ints.map { element -> "Item "+element.toString() }
    println("string:"+strings.joinToString(","))

    val charArray = charArrayOf('a', 'b', 'c')
    val tripleCharArray = charArray.flatMap { c ->charArrayOf(c, c, c).asIterable() }
    println("Triple each element in the charArray:${tripleCharArray.joinToString(",")}}")
}