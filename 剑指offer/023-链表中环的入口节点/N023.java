public class N023 {
    public ListNode entryNodeOfLoop(ListNode pHead){
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast.next != null && slow.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){//快慢指针相等则存在环
                //再建一个指针从头开始遍历，与慢指针相遇的节点就是入口节点
                ListNode p = pHead;
                while (p != slow){
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return null;
    }

}
