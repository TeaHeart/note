package org.example;

import java.util.ArrayList;
import java.util.List;

public class O06 {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        dfs(head, list);
        int[] array = new int[list.size()];
        int i = 0;
        for (Integer val : list) {
            array[i++] = val;
        }
        return array;
    }

    void dfs(ListNode head, List<Integer> list) {
        if (head == null) {
            return;
        }
        dfs(head.next, list);
        list.add(head.val);
    }
}
