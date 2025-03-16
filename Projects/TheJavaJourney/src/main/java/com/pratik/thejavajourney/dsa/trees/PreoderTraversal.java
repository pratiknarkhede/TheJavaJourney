package com.pratik.thejavajourney.dsa.trees;

import java.util.ArrayList;
import java.util.List;

public class PreoderTraversal {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=null;
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        PreoderTraversal pt=new PreoderTraversal();
        List<Integer> integers = pt.preorderTraversal(root);
        System.out.println(integers);

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> listOfTraversed=new ArrayList<>();
        doPreOrderedTraversal(root,listOfTraversed);
        return listOfTraversed;
    }

    private void doPreOrderedTraversal(TreeNode root, List<Integer> listOfTraversed) {
        if(root ==null) return;
        listOfTraversed.add(root.val);
        doPreOrderedTraversal(root.left,listOfTraversed);
        doPreOrderedTraversal(root.right,listOfTraversed);
    }
}
