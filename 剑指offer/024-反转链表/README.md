# 024-反转链表

递归至链表尾部，逐个将链表指针反转即可

```Java
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
```