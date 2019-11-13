package tree

class TreeNode {
    var data: Int = 0
    var maxHeight = 0
    //TODO
    var noOfleafnode = 1
    var children: ArrayList<TreeNode> = ArrayList()

    constructor(data: Int){
        this.data = data
    }
}