package BT

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    var root = BinaryTree(1)
    var nodeLeft = BinaryTree(2)
    var nodeRight = BinaryTree(3)

    var intArray = intArrayOf(1,2,3,4,5,6,7)

    root.left = nodeLeft
    root.right = nodeRight

    //print(countNodes(takeInputLevelwise()))
    //print(searchBST(takeInputLevelwise(),nodeLeft.data))
    //printRangeBST(takeInputLevelwise(),2,5)
    //levelWisePrint(createBSTfromArray(intArray,0,intArray.size-1))
    var inputRoot = takeInputLevelwise()
    //createLLfromBST(inputRoot)
    //inOrderTravel(inputRoot)

    printPath(rootNodepath(inputRoot,7))
}

fun printPath(list: ArrayList<Int?>?){

    for (data in 0 until list?.size!!){
        println(list.get(data))
    }
}

fun rootNodepath(root: BinaryTree?, data: Int): ArrayList<Int?>? {

    if (root == null){
        return null
    }

    if (root.data == data){
        var list = ArrayList<Int?>()
        list.add(root.data)
        return list
    }

    var left = rootNodepath(root.left,data)
    if (left!=null){
        left.add(root.data)
        return left
    }

    var right = rootNodepath(root.right,data)
    if (right!=null){
        right.add(root.data)
        return right
    }
    else{
        return null
    }
}


fun inOrderTravel(inputRoot: BinaryTree?) {
    if (inputRoot == null){
        return
    }

    inOrderTravel(inputRoot?.left)

    println(inputRoot?.data)

    inOrderTravel(inputRoot?.right)
}


fun createLLfromBST(root: BinaryTree?) {
    if(root == null || root?.left ==null && root?.right ==null){
        return
    }

    if (root?.left != null) {
        createLLfromBST(root?.left)

        var temp = root?.right
        root?.right = root?.left
        root?.left = null

        var t = root?.right
        while (t?.right != null) {
            t = t?.right
        }

        t?.right = temp
    }

    createLLfromBST(root?.right)
}

fun createBSTfromArray(intArray: IntArray, si: Int, ei: Int): BinaryTree? {

    if (si > ei){
       return null
    }

    var mid: Int = ( si + ei ) / 2
    var root = BinaryTree(intArray[mid])

    root.left = createBSTfromArray(intArray,si,mid-1)
    root.right = createBSTfromArray(intArray,mid+1,ei)
    return root
}

fun searchBST(root: BinaryTree?, data: Int) : BinaryTree? {
    if(root == null){
        return null
    }

    if(data == root.data){
        return root
    }

    if(data < root.data){
        return searchBST(root.left,data)
    }
    else {
        return searchBST(root.right,data)
    }
}


fun printRangeBST(root: BinaryTree?, k1: Int, k2: Int){
    if (root == null){
        return
    }

    if (k1 < root.data){
        printRangeBST(root.left,k1,k2)
    }

    if (k1 <= root.data && k2 >= root.data){
        print("${root.data} ")
    }

    if (k2 > root.data){
        printRangeBST(root.right,k1,k2)
    }
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

fun findNode(root: BinaryTree?, node: BinaryTree?) : Boolean {
    if (root == null || node==null){
        return false
    }

    if (root.data == node.data){
        return true
    }

    return findNode(root.left,node) || findNode(root.right,node)
}