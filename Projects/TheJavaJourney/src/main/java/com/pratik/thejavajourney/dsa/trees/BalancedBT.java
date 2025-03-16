package com.pratik.thejavajourney.dsa.trees;

public class BalancedBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        BalancedBT bbt=new BalancedBT();
        boolean balanced = bbt.isBalanced(root);
        System.out.println(balanced);
    }

    // height balance tree meaning difference between height of sibling node is never greater than 1
    public boolean isBalanced(TreeNode root) {

        int height = heightBalancedBT(root);
        return height != -1;
    }

    private int heightBalancedBT(TreeNode root) {
        if(root==null) return 0;
        int lh = heightBalancedBT(root.left);
        if (lh == -1) return -1;
        int rh = heightBalancedBT(root.right);
        if (rh == -1) return -1;
        if (Math.abs(lh - rh) > 1) return -1;
        return 1 + Math.max(lh, rh);
    }


}
