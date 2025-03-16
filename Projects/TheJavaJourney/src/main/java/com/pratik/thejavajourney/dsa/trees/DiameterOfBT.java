package com.pratik.thejavajourney.dsa.trees;

import static com.pratik.thejavajourney.dsa.trees.TreeUtil.printTree;

public class DiameterOfBT {

    /*
     * diamteter is longest distance between two nodes, not necessarily passing though root
     * */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        DiameterOfBT dbt = new DiameterOfBT();


        int diameter = dbt.diameterOfBinaryTree(root);
        System.out.println(diameter);
    }
    /*
     * simplest and one approach comes to mind to solve this is
     *
     * suppose the binary tree is fully densed fully filled
     *
     * so standing at root diameter = left_height of BT + right_height of BT
     *
     * so for each node we will calculate lh+rh and we will maintain max value
     *
     * and if the lh+rh is greater than max we will update it
     *
     * */

    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxHeight = new int[1];
        findMaxDiameter(root, maxHeight);
        //System.out.println(maxHeight[0]);

        return maxHeight[0];
    }

    private int findMaxDiameter(TreeNode root, int[] maxHeight) {

        if(root==null) return 0;
        int lh= findMaxDiameter(root.left,maxHeight);
        int rh=findMaxDiameter(root.right,maxHeight);
        if((lh+rh)>maxHeight[0]){
            maxHeight[0]=lh+rh;
        }

        return 1+Math.max(lh,rh);

    }
}
