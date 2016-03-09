// 101. Symmetric Tree
// Difficulty: Easy
// Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

// For example, this binary tree is symmetric:

//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
// But the following is not:
//     1
//    / \
//   2   2
//    \   \
//    3    3
// Note:
// Bonus points if you could solve it both recursively and iteratively.

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
// Solution A:
// public class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         if (root == null 
//             || (root.left == null && root.right == null)) {
//             return true;    
//         }
//         Stack<TreeNode> nodes1 = new Stack<TreeNode>();
//         Stack<TreeNode> nodes2 = new Stack<TreeNode>();
//         TreeNode n1 = root.left;
//         TreeNode n2 = root.right;
        
//         boolean isS = true;
        
//         while (true) {
//             if (n1 == null || n2 == null) {
//                 if (n1 == null && n2 == null) {
//                     if (nodes1.isEmpty() || nodes2.isEmpty()) {
//                         if (nodes1.isEmpty() && nodes2.isEmpty()) {
//                             break;
//                         } else {
//                             isS = false;
//                             break;
//                         }
//                     } else {
//                         n1 = nodes1.pop();
//                         n2 = nodes2.pop();
//                     }
//                 } else {
//                     isS = false;
//                     break;
//                 }
//             } else if (n1.val == n2.val) {
//                 nodes1.push(n1.right);
//                 nodes2.push(n2.left);
//                 n1 = n1.left;
//                 n2 = n2.right;
//             } else {
//                 isS = false;
//                 break;
//             }
//         }
        
//         return isS;
        
//     }
// }
// Solution B:
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return compare(root.left, root.right);
        }
    }
    
    private boolean compare(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null) {
            if (n1 == null && n2 == null) {
                return true;
            } else {
                return false;
            }
        }
        
        if (n1.val == n2.val) {
            return compare(n1.left, n2.right) && compare(n1.right, n2.left);
        } else {
            return false;
        }
        
    }
}