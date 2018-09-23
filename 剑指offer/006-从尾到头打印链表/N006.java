import java.util.ArrayList;
import java.util.Stack;

public class N006 {

    /**
     * 方法一：
     * 使用栈，把所有节点放入栈中，最后出栈打印
     * @param head
     */
    public ArrayList<Integer> printListNodeReverse(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        ArrayList<Integer> list=new ArrayList<Integer>();
        while (!stack.isEmpty()){
            list.add(stack.pop().val);
        }
        return list;
    }

    /**
     * 方法二：
     * 使用递归方式实现
     * 缺点：链表很长时可能会导致栈溢出
     * @param listNode
     */
    public ArrayList<Integer> printListNodeReverse01(ListNode listNode){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if(listNode != null){
            this.printListNodeReverse01(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(){
        this.val = val;
    }
}
