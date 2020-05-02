package BT;

public class BinaryTreeLevel {

    public static int level = 0;
    private static int current = 1;

    public static int glevel = 0;

    public static void main(String[] args) {
        BinaryTree root = BinaryTreeUseKt.takeInputLevelwise();
        level = findLevel(root);
        BinaryTree updatedRoot = swap(root,level);
        printInorder(updatedRoot);
    }

    private static void printInorder(BinaryTree root) {
        if(root == null){
            return;
        }

        if(root!=null){
            printInorder(root.getLeft());
            System.out.print(root.getData()+" ");
            printInorder(root.getRight());
        }
    }

    public static int findLevel(BinaryTree root){
        if(root == null){
            return level;
        }

        if(root.getLeft() == null && root.getRight() == null){
            return level+1;
        }

        level = level + 1;

        findLevel(root.getLeft());
        findLevel(root.getRight());

        return level;
    }

    public static BinaryTree swap(BinaryTree root, int level){
        if(root == null){
            return null;
        }

        if(level == 1){
            return root;
        }

        if(current%2!=0 && root.getLeft()!=null && root.getRight()!=null){
            int temp = root.getLeft().getData();
            root.getLeft().setData(root.getRight().getData());
            root.getRight().setData(temp);
        }


        current = current + 1;

        glevel = level-1;

        swap(root.getLeft(),glevel);
        swap(root.getRight(),glevel);


        return root;
    }

}
