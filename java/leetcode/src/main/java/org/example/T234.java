package org.example;

public class T234 {
    public boolean isPalindrome(ListNode head) {
        return isPalindrome(new ListNode(0, head), head);
    }

    boolean isPalindrome(ListNode dummy, ListNode curr) {
        if (curr == null) {
            return true;
        }
        if (!isPalindrome(dummy, curr.next) || dummy.next.val != curr.val) {
            return false;
        }
        dummy.next = dummy.next.next;
        return true;
    }
}
