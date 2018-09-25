public class N018 {

    /**
     * O(1)时间内删除链表节点
     * @param head
     * @param node
     */
    public void deleteNode(ListNode head, ListNode node){
        //删除的是尾节点，则顺序查找找到尾节点的前一节点
        if (node.next == null){
            while (head.next != node){
                head = head.next;
            }
            head.next = null;
        }else if (head == node){
            //要删除的是头节点
            head = null;
        }else {
            //要删除的是中间普通节点
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }


    /**
     * 删除链表中的重复节点
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) { // 只有0个或1个结点，则返回
            return pHead;
        }
        if (pHead.val == pHead.next.val) { // 当前结点是重复结点
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            return deleteDuplication(pNode); // 从第一个与当前结点不同的结点开始递归
        } else { // 当前结点不是重复结点
            pHead.next = deleteDuplication(pHead.next); // 保留当前结点，从下一个结点开始递归
            return pHead;
        }
    }
}
