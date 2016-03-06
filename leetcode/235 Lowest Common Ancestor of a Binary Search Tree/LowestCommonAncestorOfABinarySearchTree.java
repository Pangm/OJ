// 235. Lowest Common Ancestor of a Binary Search Tree
// Difficulty: Easy
// Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

//         _______6______
//        /              \
//     ___2__          ___8__
//    /      \        /      \
//    0      _4       7       9
//          /  \
//          3   5
// For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (p.val == q.val) {
            return p;
        }
        
        // let p.val < q.val
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        
        return lca(root, p, q);
        
    }
    
    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = null;
        
        if (p.val <= root.val && root.val <= q.val) {
            node = root;
        } else if (root.val < p.val)  {
            node = lca(root.right, p, q);
        } else {
            // root.val > q.val
            node = lca(root.left, p, q);
        }
        
        return node;
    }
}