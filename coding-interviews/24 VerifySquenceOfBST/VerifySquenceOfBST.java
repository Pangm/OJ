// 二叉搜索树的后序遍历序列
// 题目描述

// 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        
        return VerifyBST(sequence, 0, sequence.length - 1);
    }
    
    public boolean VerifyBST(int [] s, int start, int end) {
    	if (start >= end) {
            return true;
        }
        
        int i = 0;
        for (i = start; i < end; ++i) {
            if (s[i] > s[end]) {
                break;
            }
        }
        
        int j = 0;
        for (j = end - 1; j >= start; --j) {
            if (s[j] < s[end]) {
                break;
            }
        }
        
        if (i - j == 1) {
            return VerifyBST(s, start, j) && VerifyBST(s, i, end - 1);
        } else {
            return false;
        }
    }
}