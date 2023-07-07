package org.example;

public class O2_022 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        for (fast = head; fast != slow; fast = fast.next) {
            slow = slow.next;
        }
        return fast;
    }
}
