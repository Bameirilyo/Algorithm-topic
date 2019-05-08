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
