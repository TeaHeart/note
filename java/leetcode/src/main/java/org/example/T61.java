package org.example;

public class T61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int size = 0;
        for (ListNode curr = head; curr != null; curr = curr.next) {
            size++;
        }
        k %= size;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null) {
            if (k-- <= 0) {
                slow = slow.next;
            }
            fast = fast.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}
