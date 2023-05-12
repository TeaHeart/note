package org.example;

public class T1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(0, list1);
        ListNode prev = dummy;
        for (int i = 0; i < a; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next;
        for (int i = a; i < b; i++) {
            curr = curr.next;
        }
        prev.next = list2;
        while (prev.next != null) {
            prev = prev.next;
        }
        prev.next = curr.next;
        return dummy.next;
    }
}
