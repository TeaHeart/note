package org.example;

public class T2181 {
    public ListNode mergeNodes(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            int sum = 0;
            while (fast.val != 0) {
                sum += fast.val;
                fast = fast.next;
            }
            slow.val = sum;
            fast = fast.next;
            slow.next = fast;
            slow = fast;
        }
        return head;
    }
}
