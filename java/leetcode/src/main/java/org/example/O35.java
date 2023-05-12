package org.example;

import java.util.HashMap;
import java.util.Map;

public class O35 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        for (Node curr = head; curr != null; curr = curr.next) {
            map.put(curr, new Node(curr.val));
        }
        for (Node curr = head; curr != null; curr = curr.next) {
            Node node = map.get(curr);
            node.next = map.get(curr.next);
            node.random = map.get(curr.random);
        }
        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
