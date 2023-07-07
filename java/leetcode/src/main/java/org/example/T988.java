package org.example;

public class T988 {
    public String smallestFromLeaf(TreeNode root) {
        String[] holder = new String[1];
        backtrack(root, new StringBuilder(), holder);
        return holder[0];
    }

    void backtrack(TreeNode root, StringBuilder sb, String[] holder) {
        if (root == null) {
            return;
        }
        sb.append((char) ('a' + root.val));
        if (root.left == null && root.right == null) {
            String s = new StringBuilder(sb).reverse().toString();
            if (holder[0] == null || s.compareTo(holder[0]) < 0) {
                holder[0] = s;
            }
        }
        backtrack(root.left, sb, holder);
        backtrack(root.right, sb, holder);
        sb.deleteCharAt(sb.length() - 1);
    }
}
