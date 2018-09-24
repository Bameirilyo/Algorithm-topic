# 022-链表中倒数第k个节点
## 思路：
用两个指针，第一个指针先走k-1步，然后两个指针一起走。当第一个指针走到尾节点时，第二个指针指向的就是倒数第k个节点。

```Java
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
```
