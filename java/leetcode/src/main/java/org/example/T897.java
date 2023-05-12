package org.example;

public class T897 {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode();
        inorder(root, new TreeNode[]{dummy});
        return dummy.right;
    }

    void inorder(TreeNode root, TreeNode[] holder) {
        if (root == null) {
            return;
        }
        inorder(root.left, holder);
        holder[0].right = root;
        root.left = null;
        holder[0] = root;
        inorder(root.right, holder);
    }
}
