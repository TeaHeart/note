package org.example;

public class O27 {
    public boolean isPalindrome(ListNode head) {
        return isPalindrome(new ListNode[]{head}, head);
    }

    boolean isPalindrome(ListNode[] head, ListNode tail) {
        if (tail == null) {
            return true;
        }
        if (!isPalindrome(head, tail.next) || head[0].val != tail.val) {
            return false;
        }
        head[0] = head[0].next;
        return true;
    }
}
