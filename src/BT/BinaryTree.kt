package BT

class BinaryTree {
    var data : Int = 0
    var left: BinaryTree?
    var right: BinaryTree?

    constructor(data: Int){
        this.data = data
        left = null
        right = null
    }
}