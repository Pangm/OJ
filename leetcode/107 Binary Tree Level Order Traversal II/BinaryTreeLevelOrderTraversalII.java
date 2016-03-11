// 107. Binary Tree Level Order Traversal II
// Difficulty: Easy
// Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

// For example:
// Given binary tree {3,9,20,#,#,15,7},
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its bottom-up level order traversal as:
// [
//   [15,7],
//   [9,20],
//   [3]
// ]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// // Solution A:
// public class Solution {
//     public List<List<Integer>> levelOrderBottom(TreeNode root) {
//         List<List<Integer>> orders = new ArrayList<List<Integer>>();
        
//         travel(root, 0, orders);
        
//         Collections.reverse(orders);
        
//         return orders;
        
//     }
    
//     private void travel(TreeNode node, int level, List<List<Integer>> orders) {
//         if (node == null) {
//             return;
//         } else {
//             List<Integer> order;
//             if (level < orders.size()) {
//                 order = orders.get(level);
//             } else {
//                 order = new LinkedList<Integer>();
//                 orders.add(order);
//             }
//             order.add(node.val);
            
//             travel(node.left, level + 1, orders);
//             travel(node.right, level + 1, orders);
//         }
//     }
// }

 // Solution B:
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> orders = new ArrayList<List<Integer>>();
        
        if (root == null) {
          return orders;  
        } 
        
        Queue<TreeNode> nodesQ = new LinkedList<TreeNode>();
        Queue<Integer> levelsQ = new LinkedList<Integer>();
        
        TreeNode node = root;
        int level = 0;
        
        // process the root node
        List<Integer> order = new LinkedList<Integer>();
        order.add(node.val);
        orders.add(order);
        
        // process the children
        enqueue(node, nodesQ, level, levelsQ);
        
        while (!nodesQ.isEmpty()) {
            node = nodesQ.remove();
            level = levelsQ.remove();
            
            // process the node
            if (level >= orders.size()) {
                order = new LinkedList<Integer>();
                orders.add(order);
            }
            order.add(node.val);
            
            // process the children
            enqueue(node, nodesQ, level, levelsQ);
        }
        
        Collections.reverse(orders);
        
        return orders;
        
    }
    
    
    private void enqueue(TreeNode node, Queue<TreeNode> nodesQ, int level, Queue<Integer> levelsQ) {
        if (node.left != null) {
            nodesQ.offer(node.left);
            levelsQ.offer(level + 1);
        }
        
        if (node.right != null) {
            nodesQ.offer(node.right);
            levelsQ.offer(level + 1);
        }
    }
}