package stack

class Stack {

    var elements = IntArray(5)
    var currentIndex = 0

    fun pushElement(element: Int){
        elements[currentIndex] = element
        currentIndex++
    }

    fun popElement() : Int {
        if (currentIndex == 0){
            return -1
        }

        var poppedElement = elements[currentIndex-1]
        elements[currentIndex-1] = 0
        currentIndex--

        return poppedElement
    }

    fun peekElement() : Int {
        return 0
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

}
