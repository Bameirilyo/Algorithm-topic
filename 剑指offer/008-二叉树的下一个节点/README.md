# 008-二叉树的下一个节点

## 题目：
给定一颗二叉树和其中一个节点，如何找出中序遍历序列的下一个节点。树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针。
## 思路：
1. 如果一个节点有右子树，那么它的下一个节点就是它的右子树的最左节点；
2. 如果一个节点没有右子树，沿着父节点指针一直向上遍历，直到找到一个是它父节点的左子节点的节点；
3. 到根节点仍未找到，返回null。


```Java
public class N008 {
    
    public TreeLinkNode getNext(TreeLinkNode node){
        if (node == null){
            return null;
        }
        if (node.right != null){
            node = node.right;
            while (node.left != null){
                node = node.left;
            }
            return node;
        }
        while (node.next != null){
            if (node.next.left != null){
                return node.next;
            }
            node = node.next;
        }
        return null;
    }
}


class TreeLinkNode {
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;
    TreeLinkNode() { 
        
    }
}

```
