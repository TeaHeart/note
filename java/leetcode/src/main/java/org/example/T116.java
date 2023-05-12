package org.example;

public class T116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        for (Node head = root; head.left != null; head = head.left) {
            for (Node curr = head; curr != null; curr = curr.next) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
