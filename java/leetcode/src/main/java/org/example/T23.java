package org.example;

public class T23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return lists.length == 0 ? null : merge(lists, 0, lists.length);
    }

    ListNode merge(ListNode[] nodes, int left, int right) {
        if (right - left <= 1) {
            return nodes[left];
        }
        int mid = (left + right) >>> 1;
        return mergeTwo(merge(nodes, left, mid), merge(nodes, mid, right));
    }

    ListNode mergeTwo(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = left != null ? left : right;
        return dummy.next;
    }
}
