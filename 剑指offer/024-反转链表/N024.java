public class N024 {
    public ListNode reverseListNode(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode reHead = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return reHead;
    }
}
