// 二叉树中和为某一值的路径
// 题目描述

// 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

import java.util.ArrayList;
import java.util.Stack;
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
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {        
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        
        if (root != null) {
            Stack<Integer> s = new Stack<Integer>();
            s.push(root.val);
            FindPath(s, paths, root, target);
        }
        
        return paths;
        
    }
    
    public void FindPath(Stack<Integer> s, ArrayList<ArrayList<Integer>> paths, TreeNode root, int target) {
        if (target == root.val && root.left == null && root.right == null) {
            // found a path.
            ArrayList<Integer> path = new ArrayList<Integer>();
            for (int i : s) {
                path.add(i);
            }
            paths.add(path);
        } else if (target > root.val) {
            if (root.left != null) {
                s.push(root.left.val);
            	FindPath(s, paths, root.left, target - root.val);
                s.pop();
            }
            if (root.right != null) {
                s.push(root.right.val);
            	FindPath(s, paths, root.right, target - root.val);
                s.pop();
            }
        } else {
            return;
        }
    }
}