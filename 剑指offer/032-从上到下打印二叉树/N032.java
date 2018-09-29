import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class N032 {

    /**
     * 不分行从上到下打印二叉树
     * @param root
     * @return
     */
    public ArrayList<Integer> printBinaryTree(BinaryTreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<BinaryTreeNode> queue = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (queue.size() != 0) {
            BinaryTreeNode temp = queue.remove(0);
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            list.add(temp.val);
        }
        return list;
    }

    /**
     * 分行从上到下打印二叉树
     * @param root
     */
    public void printBinaryTreeNodeByLevel(BinaryTreeNode root){
        if (root == null){
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        int level = 1;
        BinaryTreeNode last = root;
        BinaryTreeNode nLast = null;
        queue.offer(root);
        System.out.print("Level" + (level++) + ":");
        while (!queue.isEmpty()){
            root = queue.poll();
            System.out.println(root.val + " ");
            if (root.left != null){
                queue.offer(root.left);
                nLast = root.left;
            }
            if (root.right != null){
                queue.offer(root.right);
                nLast = root.right;
            }
            if (root == last && !queue.isEmpty()){
                System.out.println("Level" + (level++) + ":");
                last = nLast;
            }
        }
        System.out.println();
    }



    /**
     * 分行从上到下打印二叉树
     * 递归实现
     * @param root
     */
    //用递归做的
    public ArrayList<ArrayList<Integer>> Print(BinaryTreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(root, 1, list);
        return list;
    }

    private void depth(BinaryTreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if(root == null) return;
        if(depth > list.size())
            list.add(new ArrayList<Integer>());
        list.get(depth -1).add(root.val);

        depth(root.left, depth + 1, list);
        depth(root.right, depth + 1, list);
    }
}
