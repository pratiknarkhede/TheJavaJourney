package com.pratik.thejavajourney.dsa.trees;

import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        LowestCommonAncestor lca = new LowestCommonAncestor();
        /*
        *
                                3
                               / \
                              5   1
                             / \ / \
                            6  2 0  8
                               / \
                              7   4
        * */


        TreeNode treeNode = lca.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1));
        System.out.println(treeNode.val);
    }

/*
the first approach  is

at find dfs traversal from root to the first node say p

then traversal to second node q


if they have common ancestor they will have few of the starting node in traversal as same

the last common node in traversal would be our answer

here for p=6 q=4

p ; 3 , 5, 6
q : 3,  5, 2, 4
so the last common one is 5 so it will be lca

Try to implement this solution later

*/

    /*
    more optimized solution in O(N)

    do preorder traversal ,

    if we reach the one of the expected node i.e p or q
    we will return the value of that node

    if we reach null first we will return null

    now if at any node while returning we foudn that both left and right subtree is returning non null value

    then that node will be our lowest common ancestor


    * */


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root==p || root==q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // if left subtree is returnig non null value return left
        if(left==null){
            return right;
       //if right is returning non null value return right returned value
        } else if (right == null) {
            return left;
        //if both returning non null value means we found the lca
        }else {
            return root;
        }
    }

}
