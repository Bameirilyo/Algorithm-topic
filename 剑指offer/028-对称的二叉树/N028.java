public class N028 {
    public boolean isSymmetrical(TreeNode root){
        if (root == null){ //根节点为空，是对称的
            return true;
        }
        return comRoot(root.left, root.right);
    }

    public boolean comRoot(TreeNode left, TreeNode right){
        if (left == null){ //左孩子为空，则判断右孩子是否为空，并返回结果即可
            return right == null;
        }
        if (right == null){ //到这里说明左孩子不为空，如果右孩子为空则为false
            return false;
        }
        if (left.val != right.val){ //左右孩子值不相等，为false
            return false;
        }
        //递归判断（左孩子的右孩子，右孩子的左孩子）、（左孩子的左孩子，右孩子的右孩子）
        return comRoot(left.right, right.left) && comRoot(left.left, right.right);
    }
}
