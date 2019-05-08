# 052-两个链表的第一个公共节点

## 思路：

首先遍历两个链表得到它们的长度，就能知道哪个链表比较长，以及长的链表比短的链表多几个结点。在第二次遍历的时候，在较长的链表上先走若干步，接着再同时在两个链表上遍历，找到的第一个相同的结点就是它们的第一个公共结点。

````Java
public class N052 {
    public static ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        int len1 = getListLength(head1);
        int len2 = getListLength(head2);
        ListNode longListNode = head1;
        ListNode shortListNode = head2;
        int dif = len1 - len2;
        if (len2 > len1) {
            longListNode = head2;
            shortListNode = head1;
            dif = len2 - len1;
        }
        for (int i = 0; i < dif; i++) {
            longListNode = longListNode.nextNode;
        }
        while (longListNode != null && shortListNode != null
                && longListNode != shortListNode) {
            longListNode = longListNode.nextNode;
            shortListNode = shortListNode.nextNode;
        }
        return longListNode;
    }

    private static int getListLength(ListNode head1) {
        int result = 0;
        if (head1 == null)
            return result;
        ListNode point = head1;
        while (point != null) {
            point = point.nextNode;
            result++;
        }
        return result;
    }

    class ListNode{
        int val;
        ListNode nextNode = null;
        ListNode(){
            this.val = val;
        }
    }

}

````
