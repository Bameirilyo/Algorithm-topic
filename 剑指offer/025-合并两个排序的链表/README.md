# 025-合并两个排序的链表

递归即可

```Java
public class N025 {
    public ListNode mergeListNode(ListNode p1, ListNode p2){
        if (p1 == null){
            return p2;
        }
        if (p2 == null){
            return p1;
        }
        ListNode head = null;
        if (p1.val < p2.val){
            head = p1;
            head.next = mergeListNode(p1.next, p2);
        }else {
            head = p2;
            head.next = mergeListNode(p1, p2.next);
        }
        return head;
    }
}
```