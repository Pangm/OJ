// 102. Binary Tree Level Order Traversal
// Difficulty: Easy

// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree {3,9,20,#,#,15,7},

//     3
//    / \
//   9  20
//     /  \
//    15   7

// return its level order traversal as:

// [
//   [3],
//   [9,20],
//   [15,7]
// ]

import java.util.Queue;
import java.util.LinkedList;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
       
        List<List<Integer>> order = new ArrayList<List<Integer>>();
        
        if (root != null) {
            Queue<TreeNode> qNodes = new LinkedList<TreeNode>();
            Queue<Integer> levels = new LinkedList<Integer>();
            
            TreeNode node = root;
            int level = 1;
            
            push(qNodes, node, levels, level);
            
            List<Integer> tmpList = null;// = new LinkedList<Integer>();
            while (!qNodes.isEmpty()) {
                node = qNodes.poll();
                level = levels.poll();
                
                push(qNodes, node.left, levels, level + 1);
                push(qNodes, node.right, levels, level + 1);
                
                if (order.size() < level) {
                    tmpList = new LinkedList<Integer>();
                    order.add(tmpList);
                    tmpList.add(node.val);
                } else {
                    tmpList = order.get(level - 1);
                    tmpList.add(node.val);
                }
            }
        }
        
        return order;
    }
    
    private void push(Queue<TreeNode> qNodes, TreeNode node, Queue<Integer> levels, int level) {
        if (node != null) {
            qNodes.offer(node);
            levels.offer(level);
        }

    }
}