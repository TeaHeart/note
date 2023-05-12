package org.example;

public class T421 {
    public int findMaximumXOR(int[] nums) {
        int num = 0;
        Tree tree = new Tree();
        for (int i = 1; i < nums.length; i++) {
            tree.insert(nums[i - 1]);
            num = Math.max(num, tree.xor(nums[i]));
        }
        return num;
    }

    class Tree {
        Node root = new Node();

        public void insert(int num) {
            Node curr = root;
            for (int i = Integer.MIN_VALUE; i != 0; i >>>= 1) {
                if ((num & i) == 0) {
                    if (curr.left == null) {
                        curr.left = new Node();
                    }
                    curr = curr.left;
                } else {
                    if (curr.right == null) {
                        curr.right = new Node();
                    }
                    curr = curr.right;
                }
            }
        }

        public int xor(int num) {
            Node curr = root;
            int val = 0;
            for (int i = Integer.MIN_VALUE; i != 0; i >>>= 1) {
                if ((num & i) == 0) {
                    if (curr.right != null) {
                        curr = curr.right;
                        val = val * 2 + 1;
                    } else {
                        curr = curr.left;
                        val = val * 2;
                    }
                } else {
                    if (curr.left != null) {
                        curr = curr.left;
                        val = val * 2 + 1;
                    } else {
                        curr = curr.right;
                        val = val * 2;
                    }
                }
            }
            return val;
        }

        class Node {
            Node left;
            Node right;
        }
    }
}
