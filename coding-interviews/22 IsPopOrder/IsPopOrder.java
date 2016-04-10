// 栈的压入、弹出序列

// 题目描述

// 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length || pushA.length == 0) {
            return false;
        }
        
        Stack<Integer> s = new Stack<Integer>();
        int i = 0;
        int j = 0;
        while (j < popA.length) {
            if (i < pushA.length) {
                if (pushA[i] != popA[j]) {
                	s.push(pushA[i]);
                } else {
                    ++j;                    
                }
                ++i;
            } else {
                // i = pushA.length
                if ((!s.empty()) && s.pop() == popA[j]) {
                    ++j;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}