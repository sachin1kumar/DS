package string

//Naive algorithm for pattern searching..
fun main() {
    val text = "AABAACAADAABAABA"
    val pattern = "AABA"

    val textLen = text.length
    val patternLen = pattern.length

    for (index in 0..textLen - patternLen) {
        var j = index
        var count = 0
        val firstIndex = index
        for (pIndex in 0 until patternLen) {
            if(text[j] != pattern[pIndex]) {
                break
            } else {
                count++
            }
            j++
        }

        if (count == patternLen) {
            println(firstIndex)
        }
    }
}