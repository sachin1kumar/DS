package sorting

var intArray = intArrayOf(10,5,1,4,3,9)
var _startIndex = 0
var _endIndex = intArray.size-1


fun main() {

    quicksort(intArray,_startIndex,_endIndex)

    printValues(intArray)

}

fun quicksort(intArray: IntArray, startIndex: Int, endIndex: Int) {
    _startIndex = startIndex
    _endIndex = endIndex

    if (_startIndex < _endIndex) {
        var partitionIndex = partitionIndex(intArray, _startIndex, _endIndex)

        quicksort(intArray, _startIndex, partitionIndex - 1)
        quicksort(intArray, partitionIndex + 1, _endIndex)
    }
}

fun printValues(intArray: IntArray) {
    for (i in 0..intArray.size-1){
        println(intArray[i])
    }
}

fun partitionIndex(intArray: IntArray, startIndex: Int, endIndex: Int) : Int{

    _startIndex =  startIndex
    _endIndex = endIndex

   var pivot = intArray[_endIndex]
   var count = 0

   for (i in _startIndex.._endIndex){
       if (intArray[i]<=pivot){
           count++
       }
   }

   //doing this for placing the pivot at its correct place. So, that all the elements less than pivot will be on the left and all
    //the greater will be on the right..
   var value = intArray[count]
   var temp = intArray[_endIndex]
   intArray[count] = temp
   intArray[_endIndex] = value


   while (_startIndex < _endIndex){
       if (intArray[_startIndex] < pivot){
           _startIndex++
       }
       else if (intArray[_endIndex] > pivot){
           _endIndex--
       }
       else{
           //swap the elements.
           var temp = intArray[_startIndex]
           intArray[_startIndex] = intArray[_endIndex]
           intArray[_endIndex] = temp
           _startIndex++
           _endIndex--
       }
   }

   return count
}
