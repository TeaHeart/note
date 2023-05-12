package org.example;

public class O18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (head = dummy; head != null && head.next != null; head = head.next) {
            if (head.next.val == val) {
                head.next = head.next.next;
            }
        }
        return dummy.next;
    }
}
