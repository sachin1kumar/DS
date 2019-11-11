package tree

import java.util.*


fun main() {

    var root = TreeNode(1)
    var node1 = TreeNode(2)
    var node2 = TreeNode(3)

    root.children.add(node1)
    root.children.add(node2)

    printTree(root)

    //no. of nodes..
    //println("No. of nodes: ${noOfNodes(root)}")
    //levelWisePrint(takeInputLevelwise())

    //println(height(takeInputLevelwise()))
    println(printAtlevelk(takeInputLevelwise(),2))

}

fun height(root: TreeNode) : Int{
    if (root == null){
        return 0
    }
    else{
        for (i in 0 until root.children.size){
            var height = height(root.children[i])
            if (height > root.maxHeight){
                root.maxHeight = height
            }
        }
    }
    return root.maxHeight + 1
}

fun printAtlevelk(root: TreeNode, k: Int){
    if (root == null){
        return
    }
    if (k==0){
        println(root.data)
    }

    for (i in 0 until root.children.size){
        printAtlevelk(root.children[i],k-1)
    }
}

fun printTree(root: TreeNode) {

    if (root == null) {
        return
    }

    print(root.data)
    print(":")

    for (i in 0 until root.children.size) {
        print(root.children[i].data)
        print(",")
    }

    println()

    //call recursion on children..
    for (i in 0 until root.children.size) {
        printTree(root.children[i])
    }
}

fun takeInput() : TreeNode {
    println("Enter data:")
    var data = Scanner(System.`in`).nextInt()

    var root = TreeNode(data)

    println("Enter number of children:")
    var n = Scanner(System.`in`).nextInt()

    for (i in 0 until n){
        var node = takeInput()
        root.children.add(node)
    }

    return root
}

fun takeInputLevelwise() : TreeNode {
    var rootData = 0
    println("Enter root data:")
    rootData = Scanner(System.`in`).nextInt()

    var root = TreeNode(rootData)

    var queue: Queue<TreeNode> = ArrayDeque<TreeNode>()
    queue.add(root)

    while (queue.size!=0){
        //get the front node..
        var front = queue.element()
        //pop
        queue.poll()

        println("Enter the number of children of ${front.data}")
        var n = Scanner(System.`in`).nextInt()

        for (i in 0 until n){
            println("Enter the $i th child of ${front.data}")
            var childData = Scanner(System.`in`).nextInt()
            //create child node.
            var child = TreeNode(childData)
            front.children.add(child)
            // add to queue..
            queue.add(child)
        }
    }

    return root
}

fun levelWisePrint(root: TreeNode){
    var queue: Queue<TreeNode> = ArrayDeque<TreeNode>()
    queue.add(root)

    while (queue.size!=0) {

        //get the front node..
        var front = queue.element()

        print(front.data)
        print(":")

        //pop
        queue.poll()


        for (i in 0 until front.children.size){
            print(front.children[i].data)
            print(",")
            // add to queue..
            queue.add(front.children[i])
        }
        println()
    }

}

fun noOfNodes(root: TreeNode) : Int{
    var count = 1
    for (i in 0 until root.children.size){
        count+= noOfNodes(root.children[i])
    }
    return count
}