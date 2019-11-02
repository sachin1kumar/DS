package sorting

fun main() {

    var intArray = intArrayOf(10,5,1,4,3,9)

    for (index in 1..intArray.size-1){
        //pick element at index '1' first..
        var element = intArray[index]

        var oppositeIndex = index-1

        while (oppositeIndex >= 0 && element < intArray[oppositeIndex]){
            intArray[oppositeIndex+1] = intArray[oppositeIndex]
            oppositeIndex--
        }

        intArray[oppositeIndex+1] = element

    }

    //print array..
    for (j in 0..intArray.size-1){
        println(intArray[j])
    }

}