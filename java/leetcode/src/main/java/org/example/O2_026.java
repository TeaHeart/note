package org.example;

public class O2_026 {
    public void reorderList(ListNode head) {
        ListNode left = head;
        ListNode right = reverse(middleNode(head));
        while (left.next != null) {
            ListNode next = left.next;
            left.next = right;
            left = right;
            right = next;
        }
    }

    ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
