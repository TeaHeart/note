package org.example;

import java.util.HashMap;
import java.util.Map;

public class T1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0, head);
        int prefix = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            prefix += node.val;
            map.put(prefix, node);
        }
        prefix = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            prefix += node.val;
            node.next = map.get(prefix).next;
        }
        return dummy.next;
    }
}
