// 110. Balanced Binary Tree
// Difficulty: Easy
// Given a binary tree, determine if it is height-balanced.

// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

import java.lang.Math;
// Solution A 
// Preorder traversal 的方法, 有明显的重复判断
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// public class Solution {
//     public boolean isBalanced(TreeNode root) {
//         if (root == null || (root.right == null && root.left == null)) {
//             return true;
//         }
        
//         if (Math.abs(heightOfTree(root.left) - heightOfTree(root.right)) <= 1) {
//             return isBalanced(root.left) && isBalanced(root.right);
//         } else {
//             return false;
//         }
        
//     }
    
//     public int heightOfTree(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
        
//         return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
//     }
// }


// Solution B 
// Postorder traversal 的方法
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
    public boolean isBalanced(TreeNode root) {
        return isBalanced(root, new Height());
    }
    
    public boolean isBalanced(TreeNode root, Height h) {
        if (root == null) {
            h.height = 0;
            return true;
        } else if (root.left == null && root.right == null) {
            h.height = 1;
            return true;
        } else {
            Height leftHeight = new Height();
            Height rightHeight = new Height();
            if (isBalanced(root.left, leftHeight) && isBalanced(root.right, rightHeight)) {
                h.height = Math.max(leftHeight.height, rightHeight.height) + 1;
                if (Math.abs(leftHeight.height - rightHeight.height) <= 1) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
    
    public class Height {
        public int height;
        
        public Height() {
            height = 0;
        }
        
        public Height(int h) {
            height = h;
        }
    }
}