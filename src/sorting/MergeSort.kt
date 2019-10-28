package sorting

fun main() {

    var firstArray = intArrayOf(1,9,10,12)
    var secondArray = intArrayOf(2,6,15,20,40)

    var sortedArray = Array(firstArray.size+secondArray.size){0}

    var firstIndex = 0
    var secondIndex = 0
    var sortedIndex = 0


    while (firstIndex < firstArray.size &&
        secondIndex < secondArray.size){

        if (firstArray[firstIndex] < secondArray[secondIndex]){
            sortedArray[sortedIndex] = firstArray[firstIndex]
            sortedIndex++
            firstIndex++
        }
        else if(firstArray[firstIndex] > secondArray[secondIndex]){
            sortedArray[sortedIndex] = secondArray[secondIndex]
            sortedIndex++
            secondIndex++
        }
        else{
            sortedArray[sortedIndex] = secondArray[secondIndex]
            sortedIndex++
            sortedArray[sortedIndex] = firstArray[firstIndex]
            sortedIndex++

            firstIndex++
            secondIndex++
        }
    }


    while (firstIndex < firstArray.size){
        sortedArray[sortedIndex] = firstArray[firstIndex]
        sortedIndex++
        firstIndex++
    }

    while (secondIndex < secondArray.size){
        sortedArray[sortedIndex] = secondArray[secondIndex]
        sortedIndex++
        secondIndex++
    }

    for (element in sortedArray){
        println(element)
    }
}