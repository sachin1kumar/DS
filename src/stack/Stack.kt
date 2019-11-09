package stack

class Stack {

    var elements = IntArray(5)
    var currentIndex = 0

    fun pushElement(element: Int) : Int{
        if (currentIndex == elements.size){
            return -1
        }
        elements[currentIndex] = element
        currentIndex++

        return 0
    }

    fun popElement() : Int {
        if (isEmpty()){
            return -1
        }

        var poppedElement = elements[currentIndex-1]
        elements[currentIndex-1] = 0
        currentIndex--

        return poppedElement
    }

    //top element..
    fun topElement() : Int {
        return elements[currentIndex-1]
    }

    //check for isEmpty..
    fun isEmpty() : Boolean {
        if (currentIndex == 0){
            return true
        }
        return false
    }

}


fun main() {
    var stack = Stack()
    stack.pushElement(1)
    stack.pushElement(2)
    stack.pushElement(3)

    for (element in stack.elements){
        println(element)
    }

    stack.popElement()

    println("----------------------")

    for (element in stack.elements){
        println(element)
    }

    println("---top element----"+stack.topElement())

}
