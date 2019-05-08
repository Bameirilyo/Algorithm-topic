# 求链表的中间节点

## 题目：

求链表的中间结点。如果链表中结点总数为奇数，返回中间结点；如果结点总数为偶数，返回中间两个结点的任意一个。

## 思路：

设置两个指针fast和slow，两个指针同时向前走，fast指针每次走两步，slow指针每次走一步，直到fast指针走到最后一个结点时，此时slow指针所指的结点就是中间结点。注意链表为空，链表结点个数为1和2的情况。时间复杂度为O（n）。

````Java
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

````
