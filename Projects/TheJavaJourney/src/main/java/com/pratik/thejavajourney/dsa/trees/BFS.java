package com.pratik.thejavajourney.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



/*1. Initialize levelOrderList as an empty list.
2. If root is null, return levelOrderList.
3. Initialize bfsQ as an empty queue.
4. Enqueue root into bfsQ.

5. While bfsQ is not empty:
   a. Set qSize to the current size of bfsQ.
   b. Initialize currentLevel as an empty list.

   c. For i from 0 to qSize - 1:
      i. Dequeue a node from bfsQ.
      ii. Add the node's value to currentLevel.
      iii. If the node has a left child, enqueue it into bfsQ.
      iv. If the node has a right child, enqueue it into bfsQ.

   d. Add currentLevel to levelOrderList.

6. Return levelOrderList.
*/

public class BFS {


    public static void main(String[] args) {
        // Create the following binary tree:
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
        //   /
        //  7

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        List<List<Integer>> levelOrderTraversal = levelOrder(root);
        System.out.println(levelOrderTraversal);

    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();
        if (root == null) return levelOrderList;
        // we use queue because we want fifo operation here, since we want visit children of each node one by one

        Queue<TreeNode> bfsQ = new LinkedList<>();
        bfsQ.offer(root);

        while (!bfsQ.isEmpty()) {
            int qSize = bfsQ.size();
            List<Integer> currentLevel = new ArrayList<>();
            //now since we want to make sure we are adding elements of same level in the inner list , we would need to iterate
            // for children of all elememnts present in queue for that we keep track of size for inner loop and we keep adding the elements to the curreneLevel
            //list till loop breaks
            for (int i=0;i<qSize;i++) {
                TreeNode qElement = bfsQ.poll();
                if (qElement.left != null) {
                    bfsQ.offer(qElement.left);
                }
                if (qElement.right != null) {
                    bfsQ.offer(qElement.right);
                }
                currentLevel.add(qElement.val);

            }
            levelOrderList.add(currentLevel);
        }

        return levelOrderList;
    }




}
