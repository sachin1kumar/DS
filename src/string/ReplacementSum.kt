package string


fun main() {
    val num1 = 5466
    val num2 = 4555

    val output = ArrayList<Int>()

    //replace 5 with 6 in both
    val convertedNum1 = replaceDigit(5, num1)
    val convertedNum2 = replaceDigit(5, num2)
    output.add(convertedNum1 + convertedNum2)

    //replace 6 with 5 in both
    val convertNum1 = replaceDigit(6, num1)
    val convertNum2 = replaceDigit(6, num2)
    output.add(convertNum1 + convertNum2)

    //replace 5 with 6 in first
    val convertedNum11 = replaceDigit(5, num1)
    output.add(convertedNum11 + num2)

    //replace 5 with 6 in second
    val convertedNum12 = replaceDigit(5, num2)
    output.add(num1 + convertedNum12)

    //replace 6 with 5 in first
    val convertedNum13 = replaceDigit(6, num1)
    output.add(convertedNum13 + num2)

    //replace 6 with 5 in second
    val convertedNum14 = replaceDigit(6, num2)
    output.add(convertedNum13 + num1)

    //iterate output..
    printOutput(output)
    //to get the final output sort the Al and print first and last elements.
}

fun printOutput(output: ArrayList<Int>) {
    for (index in 0 until output.size) {
        System.out.println(output[index])
    }
}

private fun replaceDigit(first: Int, num: Int) : Int {
    val str = num.toString()

    val stringBuilder = java.lang.StringBuilder(str)

    if (first == 5) {
        for (index in 0 until stringBuilder.length) {
            if (stringBuilder[index] == '5') {
                stringBuilder.setCharAt(index, '6')
            }
        }
    } else if(first == 6) {
        for (index in 0 until stringBuilder.length) {
            if (stringBuilder[index] == '6') {
                stringBuilder.setCharAt(index, '5')
            }
        }
    }
    return Integer.parseInt(stringBuilder.toString())
}