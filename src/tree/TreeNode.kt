package tree

class TreeNode {
    var data: Int = 0
    var maxHeight = 0
    var children: ArrayList<TreeNode> = ArrayList()

    constructor(data: Int){
        this.data = data
    }
}