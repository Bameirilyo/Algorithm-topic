# 027-二叉树的镜像

## 题目：
输入一棵二叉树，输出它的镜像。

## 思路：
前序遍历这棵树的每个节点，如果遍历到的节点有子节点，就交换它的两个子节点。当交换完所有非叶结点的左、右子节点之后，就得到了树的镜像。

```Java
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
```