// 重建二叉树
// 题目描述

// 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        
        return reConstructBT(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }
    
    public TreeNode reConstructBT(int [] pre, int preStart, int preEnd, 
                                 int [] in,  int inStart,  int inEnd) {
        TreeNode root = new TreeNode(pre[preStart]);
        
        int rootPos = 0;
        for (int i = inStart; inStart <= inEnd; ++i) {
            if (root.val == in[i]) {
                rootPos = i;
                break;
            }
        }
        int lenLeft = rootPos - inStart;
        int lenRight = inEnd - rootPos;
        
        if (lenLeft == 0) {
            root.left = null;
        } else {
        	root.left = reConstructBT(pre, preStart + 1, preStart + lenLeft, in, inStart, rootPos - 1);
        }
        
        if (lenRight == 0) {
            root.right = null;
        } else {
        	root.right = reConstructBT(pre, preStart + lenLeft + 1, preEnd, in, rootPos + 1, inEnd);
        }
        
        return root;
    }
}