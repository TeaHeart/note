package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class T445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode();
        for (int carry = 0; !s1.isEmpty() || !s2.isEmpty() || carry != 0; carry /= 10) {
            carry += (s1.isEmpty() ? 0 : s1.pop()) + (s2.isEmpty() ? 0 : s2.pop());
            dummy.next = new ListNode(carry % 10, dummy.next);
        }
        return dummy.next;
    }
}
