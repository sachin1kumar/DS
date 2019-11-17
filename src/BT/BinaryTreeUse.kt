package BT

import tree.TreeNode
import java.util.*

fun main() {
    var root = BinaryTree(1)
    var nodeLeft = BinaryTree(2)
    var nodeRight = BinaryTree(3)

    root.left = nodeLeft
    root.right = nodeRight

    //print(countNodes(takeInputLevelwise()))
    print(findNode(takeInputLevelwise(),nodeLeft))
}

fun printBT(root: BinaryTree?){
    if (root==null){
        return
    }

    print("${root.data}:")

    if (root.left!=null){
        print("L:${root.left?.data},")
    }

    if (root.right!=null){
        print("R:${root.right?.data}")
    }
    println()

    printBT(root.left)
    printBT(root.right)
}

fun takeInputLevelwise(): BinaryTree? {
    println("Enter root data:")
    var rootData = Scanner(System.`in`).nextInt()

    if (rootData == -1) {
        return null
    }

    var root = BinaryTree(rootData)

    var queue: Queue<BinaryTree> = ArrayDeque<BinaryTree>()
    queue.add(root)

    while (queue.size != 0) {
        //get the front node..
        var front = queue.element()
        //pop
        queue.poll()

        println("Enter left child data of ${front.data}")
        var left = Scanner(System.`in`).nextInt()
        if (left!=-1) {
            var leftChild = BinaryTree(left)
            front.left = leftChild

            // add to queue..
            queue.add(leftChild)
        }

        println("Enter right child data of ${front.data}")
        var right = Scanner(System.`in`).nextInt()
        if (right!=-1) {
            var rightChild = BinaryTree(right)
            front.right = rightChild

            // add to queue..
            queue.add(rightChild)
        }
    }

    return root
}

fun levelWisePrint(root: BinaryTree?){
    var queue: Queue<BinaryTree> = ArrayDeque<BinaryTree>()
    queue.add(root)

    while (queue.size!=0) {

        //get the front node..
        var front = queue.element()

        print(front.data)
        print(":")

        //pop
        queue.poll()


        if (front.left!=null) {
            print("L:${front.left?.data},")
            // add to queue..
            queue.add(front.left)
        }

        if (front.right!=null) {
            print("R:${front.right?.data}")
            // add to queue..
            queue.add(front.right)
        }

        println()
    }

}

fun countNodes(root: BinaryTree?) : Int{
    var count = 1
    if (root == null){
        return 0
    }
    else {
        count += countNodes(root.left) + countNodes(root.right)
    }

    return count
}

fun findNode(root: BinaryTree?,node: BinaryTree?) : Boolean {
    if (root == null || node==null){
        return false
    }

    if (root.data == node.data){
        return true
    }

    return findNode(root.left,node) || findNode(root.right,node)
}