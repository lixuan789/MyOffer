package offer;

import utils.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class Code52GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lena = 0;
        int lenb = 0;
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != null) {
            lena++;
            pa = pa.next;
        }
        while (pb != null) {
            lenb++;
            pb = pb.next;
        }
        boolean flag = false;//默认链表A大于链表B
        if (lenb > lena) {
            flag = true;
        }
        int interval = Math.abs(lena - lenb);
        while (interval-- > 0) {
            if (flag) {
                headB = headB.next;
            } else {
                headA = headA.next;
            }
        }
        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        if (headA == null || headB == null) {
            return null;
        }
        return headA;
    }
}
