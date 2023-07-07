package org.example;

public class T24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        for (ListNode curr = dummy.next; curr != null && curr.next != null; curr = curr.next) {
            ListNode next = curr.next;
            curr.next = next.next;
            prev.next = next;
            next.next = curr;
            prev = curr;
        }
        return dummy.next;
    }
}
