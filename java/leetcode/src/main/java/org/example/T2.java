package org.example;

public class T2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        int carry = 0;
        for (ListNode curr = dummy; l1 != null || l2 != null || carry > 0; curr = curr.next) {
            int value = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = value / 10;
            value %= 10;
            curr.next = new ListNode(value);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return dummy.next;
    }
}
