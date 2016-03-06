// 104. Maximum Depth of Binary Tree
// Difficulty: Easy
// Given a binary tree, find its maximum depth.

// The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

import java.lang.*;
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
    public int maxDepth(TreeNode root) { 
        if (root == null) { // leaf node
            return 0;
        } else {  // interval node
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
        
    }
}