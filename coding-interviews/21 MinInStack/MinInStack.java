// 包含min函数的栈
// 题目描述

// 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。

import java.util.Stack;

public class Solution {
    private Stack<Integer> s = new Stack<Integer>();
    private Stack<Integer> min_s = new Stack<Integer>();
    
    public void push(int node) {
        s.push(node);
        
        if (min_s.empty()) {
            min_s.push(node);
        } else {
            if (min_s.peek() >= node) {
                min_s.push(node);
            } else {
                min_s.push(min_s.peek());
            }
        }
    }
    
    public void pop() {
        s.pop();
        min_s.pop();        
    }
    
    public int top() {
        return s.peek();
    }
    
    public int min() {
        return min_s.peek();
    }
}