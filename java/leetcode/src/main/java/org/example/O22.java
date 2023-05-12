package org.example;

public class O22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            fast = fast.next;
            if (k-- <= 0) {
                slow = slow.next;
            }
        }
        return slow;
    }
}
