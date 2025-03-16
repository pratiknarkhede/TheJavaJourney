package com.pratik.thejavajourney.dsa.trees;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=null;
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        InorderTraversal it=new InorderTraversal();
        List<Integer> inorderTraversedIntegers = it.inorderTraversal(root);
        System.out.println(inorderTraversedIntegers);

    }

    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> listOfTraversed=new ArrayList<>();
        doInorderTraversal(root,listOfTraversed);
        return listOfTraversed;
    }

    private void doInorderTraversal(TreeNode root, List<Integer> listOfTraversed) {
        if(root==null) return ;
        doInorderTraversal(root.left,listOfTraversed);
        listOfTraversed.add(root.val);
        doInorderTraversal(root.right,listOfTraversed);
    }
}
