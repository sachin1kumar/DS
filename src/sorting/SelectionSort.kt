package sorting

fun main() {

    var array = intArrayOf(8,5,1,4,6,2)

    for(index in 0 until array.size-1){
        var (minimum,minIndex) = minElement(index,array)
        //swap min with the element at current position...
        var currentElement = array[index]
        array[index] = minimum
        array[minIndex] = currentElement
    }

    for(index in 0 until array.size){
        println(array[index])
    }

}

fun minElement(index: Int, array: IntArray): Pair<Int,Int>{

    var min = array[index]
    var minIndex = index

    for (i in index + 1 until array.size){

        if(array[i]< min){
            min = array[i]
            minIndex = i
        }

    }

    return Pair(min,minIndex)
}