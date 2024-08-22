package com.pratik.thejavajourney.dsa.trees;

import com.sun.source.tree.Tree;

import java.util.Stack;

public class DFS {
    private static int count = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);

        // Tree structure:
        //           1
        //         /   \
        //        2     3
        //       / \   / \
        //      4   5 6   7
        //     / \ / \
        //    8  9 10 11


        int maxDepth = maxDepth(root);
        System.out.println("maxLengthOf tree " + maxDepth);
        maxDepthIterative(root);
    }

    /*
     * since recurrsion is inherentaly usign stack we arent using it explicitly here
     * */

    private static int maxDepth(TreeNode root) {
        if (root == null) return -1;
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        // we are adding 1 because depth will be 1 plus depth of subtree
        return (leftMaxDepth >= rightMaxDepth ? leftMaxDepth : rightMaxDepth)+1;
    }



    /*
     * Iterative way
     *
     * */

    private static int maxDepthIterative(TreeNode root){
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root); // Initialize a stack with the root node

        while (!stack.isEmpty()) {
            root = stack.pop(); // Get the top node from the stack
            System.out.println(root.val); // Visit the node

            // Push the right child first, then the left (to ensure left is explored first)
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return 0;
    }



    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " "); // Print current node
        printTree(root.left); // Recursively print left subtree
        printTree(root.right); // Recursively print right subtree
    }


}
