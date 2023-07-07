package org.example;

public class T1721 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        for (ListNode node = fast.next; node != null; node = node.next) {
            slow = slow.next;
        }
        int temp = slow.val;
        slow.val = fast.val;
        fast.val = temp;
        return head;
    }
}
