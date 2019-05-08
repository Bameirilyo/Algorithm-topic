public class FindMid {
//    当n为偶数时，得到的中间结点是第n/2 + 1个结点。比如链表有6个节点时，得到的是第4个节点。
    private static ListNode findMid(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        //每次移动时，让fast结点移动两位，slow结点移动一位
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //直到fast结点移动到null时，此时slow指针指向的位置就是中间结点的位置
        return slow;
    }
}
