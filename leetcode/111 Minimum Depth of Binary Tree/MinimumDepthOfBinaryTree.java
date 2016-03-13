// 111. Minimum Depth of Binary Tree
// Difficulty: Easy
// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        Stack<Integer> depths = new Stack<Integer>();
        int mDepth = Integer.MAX_VALUE;
        
        int depth = 1;
        TreeNode node = root;
        Boolean shouldPop = false;
        while (true) {
            if (depth < mDepth && node != null) {
                if (node.left == null && node.right == null) {
                    // leaf node: find a path
                    mDepth = depth;
                    
                    // travel another path
                    if (nodes.empty()) {
                        break;
                    } else {
                        node = nodes.pop();
                        depth = depths.pop();
                    }
                } else {
                    // inner node
                    depth++;
                    if (node.right != null) {
                        nodes.push(node.right);
                        depths.push(depth);
                    }
                    node = node.left;
                }
            } else {
                
                if (nodes.empty()) {
                    break;
                } else {
                    node = nodes.pop();
                    depth = depths.pop();
                }
            }
        }
        
        return mDepth;
    }
}