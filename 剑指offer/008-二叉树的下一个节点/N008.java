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
