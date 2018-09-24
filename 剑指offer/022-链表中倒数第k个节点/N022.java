public class N022 {
    public LinkNode findElem(LinkNode head, int k){
        if (head == null || k < 1){
            return null;
        }
        LinkNode p1 = head;
        LinkNode p2 = head;
        for (int i = 0; i < k - 1; k++){
            if (p1.next != null){
                p1 = p1.next;
            }else {
                return null;
            }
        }
        while (p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}

class LinkNode{
    int val;
    LinkNode next;
    public LinkNode () {

    }
}
