package com.pratik.thejavajourney.dsa.trees;

public class TreeUtil {

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " "); // Print current node
        printTree(root.left); // Recursively print left subtree
        printTree(root.right); // Recursively print right subtree
    }
}
