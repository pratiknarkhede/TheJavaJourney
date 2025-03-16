package com.pratik.thejavajourney.dsa.trees;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElement {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(0);
        root.right.right.right = new TreeNode(8);

        /*
                                4
                               / \
                              2   6
                             / \ / \
                            1  3 5  7
                           /         \
                          0           8

    */


        KthSmallestElement kthSmallestElement = new KthSmallestElement();
        int kthSmallest = kthSmallestElement.kthSmallest(root, 3);
        System.out.println("kth smallest element is : "+kthSmallest);
    }
    /*
      one of the approach , which can be considered as naive solution;
      traverse all the element using dfs
      store them in array
      sort the array

      loop through the array to find kth element which should be kth smallest


      But better solution is , to use BST property
      that inorder traversal of bst is always sorted

      so we will do inorder traversal till kth element

    * */


    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list=new ArrayList<>();
        doInorderTraversal(root,list);
        System.out.println(list);
        return list.get(k-1);
    }

    private void doInorderTraversal(TreeNode root, List<Integer> list) {
        if(root==null) return ;
        doInorderTraversal(root.left,list);
        list.add(root.val);
        doInorderTraversal(root.right,list);
    }
}
