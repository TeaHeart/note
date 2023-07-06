package org.example;

public class T86 {
    public ListNode partition(ListNode head, int x) {
        ListNode ltDummy = new ListNode();
        ListNode ltTail = ltDummy;
        ListNode geDummy = new ListNode();
        ListNode geTail = geDummy;
        for (ListNode curr = head; curr != null; curr = curr.next) {
            if (curr.val < x) {
                ltTail = ltTail.next = curr;
            } else {
                geTail = geTail.next = curr;
            }
        }
        ltTail.next = geDummy.next;
        geTail.next = null;
        return ltDummy.next;
    }
}
