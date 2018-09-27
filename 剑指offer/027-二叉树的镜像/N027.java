public class N027 {
    public void mirrorRecursively(BinaryTreeNode node){
        if (node == null){
            return;
        }
        if (node.left == null && node.right == null){
            return;
        }
        BinaryTreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        if (node.left != null){
            mirrorRecursively(node.left);
        }
        if (node.right != null){
            mirrorRecursively(node.right);
        }
    }
}
