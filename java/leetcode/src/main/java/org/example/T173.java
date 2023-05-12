package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class T173 {
    class BSTIterator {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode next;

        public BSTIterator(TreeNode root) {
            next = root;
        }

        public int next() {
            while (next != null) {
                stack.push(next);
                next = next.left;
            }
            TreeNode curr = stack.pop();
            next = curr.right;
            return curr.val;
        }

        public boolean hasNext() {
            return next != null || !stack.isEmpty();
        }
    }
}
