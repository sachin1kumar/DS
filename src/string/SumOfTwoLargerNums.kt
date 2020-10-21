package string

import java.lang.StringBuilder

val stringBuilder = StringBuilder()
fun main() {

    val str1 = "3333311111111111"
    val str2 = "44422222221111"
    var len1 = str1.length
    var len2 = str2.length
    var carry = 0

    //iterate str1 and str2..
    while (len1 != 0 && len2 != 0) {
        val integer1 = getFirstInt(str1[len1 - 1].toString())
        val integer2 = getFirstInt(str2[len2 - 1].toString())
        val sum = integer1 + integer2 + carry
        carry = sum / 10
        val element = sum % 10
        //add it to StringBuilder..
        addToStrBuilder(element)
        len1--
        len2--
    }

    while (len1 != 0) {
        val integer1 = getFirstInt(str1[len1 - 1].toString()) + carry
        //add it to StringBuilder..
        addToStrBuilder(integer1)
        carry = 0
        len1--
    }

    while (len2 != 0) {
        val integer2 = getFirstInt(str2[len2 - 1].toString()) + carry
        //add it to StringBuilder..
        addToStrBuilder(integer2)
        carry = 0
        len2--
    }

    //print string builder..
    //Shortcut, it can be done using two pointer approach..
    val stringType = stringBuilder.toString().reversed()

    for (value in stringType) {
        print(value)
    }
}

private fun getFirstInt(num: String): Int {
    return num.toInt()
}

private fun addToStrBuilder(element: Int): StringBuilder {
    stringBuilder.append(element)
    return stringBuilder
}
