package hashmap

fun main() {
    val strArray = arrayOf<String>("abdc", "efgj", "abcd", "efgj", "pqrs")

    for (index in strArray.indices) {
        val str = strArray[index]
        val bucketIndex = hashFuntion(str, strArray.size)
        insertStringInArray(bucketIndex, str, strArray)
    }
}

private fun hashFuntion(str: String, bucketArraySize: Int) : Int {
    //Generate hashcode..
    val hashCode: Int =  str.hashCode()
    //Use compression to generate bucket array index..
    return hashCode % bucketArraySize
}

fun insertStringInArray(bucketIndex: Int, str: String, strArray: Array<String>) {
    if (strArray[bucketIndex] != "") {
        strArray[bucketIndex] = str
    } else {
        //handle collision via closed hashing or we call it separate chaining..

    }
}