// 从上往下打印二叉树
// 题目描述

// 从上往下打印出二叉树的每个节点，同层节点从左至右打印。

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        
        if (root == null) {
            return numbers;
        }
        
       	q.offer(root);
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            numbers.add(node.val);
            
            if (node.left != null) {
                q.offer(node.left);
            }
            
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        
        return numbers;
    }
}