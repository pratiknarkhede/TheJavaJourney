package com.pratik.thejavajourney.dsa.trees;

public class MaximumDepthBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(4);
        MaximumDepthBT mdepth = new MaximumDepthBT();
        int height = mdepth.maxDepth(root);
        System.out.println(height);

    }


    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return 1 + Math.max(lh, rh);
    }
}
