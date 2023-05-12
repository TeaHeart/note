package org.example;

public class T19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        for (ListNode fast = dummy; fast != null; fast = fast.next) {
            if (n-- < 0) {
                slow = slow.next;
            }
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
