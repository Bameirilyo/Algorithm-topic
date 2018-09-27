# 026-树的子结构

## 题目：
输入两棵二叉树A和B，判断B是不是A的子结构。

## 思路：
递归的方式判断，若找到与B节点相同的节点则递归判断左右子树是否一致。

```Java
public class N026 {
    public boolean hasSubtree(BinaryTreeNode root1,BinaryTreeNode root2){
        boolean result = false;
        if (root1 != null && root2 != null){
            if (root1.val == root2.val){
                result = fun(root1, root2);
            }
            //找不到则以左儿子为起点继续判断
            if (!result){
                result = hasSubtree(root1.left, root2);
            }
            //找不到则以右儿子为起点继续判断
            if (!result){
                result = hasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean fun(BinaryTreeNode root1,BinaryTreeNode root2){
        if (root2 == null){
            return true;
        }
        if (root1 == null){
            return false;
        }
        if (root1.val != root2.val){
            return false;
        }
        return fun(root1.left, root2.left) && fun(root1.right, root2.right);
    }
}


class BinaryTreeNode{
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;
}
```