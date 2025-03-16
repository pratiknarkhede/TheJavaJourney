package com.pratik.thejavajourney.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        LevelOrderTraversal lot = new LevelOrderTraversal();
        List<List<Integer>> lists = lot.levelOrder(root);
        System.out.println(lists);

    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        TreeNode p = root;
        List<List<Integer>> levelOrderList = new ArrayList<>();
        if(root==null) return levelOrderList;
        // we will initially add the root to the queue which we are maintaining to keep track if all children
        // pending to be explored
        nodeQueue.add(p);

        // as sooon as the queue becomes empty , we will return main container list which has sublist in form of traversal at each level
        while (!nodeQueue.isEmpty()) {
            // sublist to gather all the nodes at current level
            List<Integer> levelWiseElementList = new ArrayList<>();
            // we will check the queue size , which will give us idea of breadth size (number of elements on current level)

            // for each node in current level , which will be equal to size of queue
            // will add the left and right children to the queue if the children exist
            // afterwards once all the left and right children of particular node , which we are peeking from queue are explored
            // we will deque the element

            // and then after the size we mainained becomes zero meaning ,when all the nodes at that level are exlpored
            // we will add the sublist to our container list of list

            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                if (nodeQueue.peek().left != null) {
                    nodeQueue.offer(nodeQueue.peek().left);
                }
                if (nodeQueue.peek().right != null) {
                    nodeQueue.offer(nodeQueue.peek().right);
                }
                levelWiseElementList.add(nodeQueue.poll().val);
            }
            levelOrderList.add(levelWiseElementList);
        }
        return  levelOrderList;
    }
}
