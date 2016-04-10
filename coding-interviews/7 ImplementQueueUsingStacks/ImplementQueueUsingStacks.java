// 用两个栈实现队列
// 题目描述

// 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

import java.util.Stack;
 
public class Solution {
    // Stack<Integer> stack1 = new Stack<Integer>();
    // Stack<Integer> stack2 = new Stack<Integer>();   
    private Stack<Integer> firstStack = new Stack<Integer>();
    private Stack<Integer> secondStack = new Stack<Integer>();
    private int front = 0;
     
    // Push element x to the back of queue.
    public void push(int x) {
        if (firstStack.empty() && secondStack.empty()) {
            front = x;
        }
         
        while(!secondStack.empty()) {
            int value = secondStack.peek();
            firstStack.push(value);
            secondStack.pop();
        }
         
        firstStack.push(x);
    }
 
    // Removes the element from in front of queue.
    public int pop() {
        if (firstStack.empty() && secondStack.empty()) {
            return 0;
        }
         
        while(!firstStack.empty()) {
            int value = firstStack.peek();
            secondStack.push(value);
            firstStack.pop();
        }
         
        int r = secondStack.pop();
         
        if (!secondStack.empty()) {
            front = secondStack.peek();
        }
         
        return r;
    }
 
    // Get the front element.
    public int peek() {
        return front;
    }
 
    // Return whether the queue is empty.
    public boolean empty() {
        return firstStack.empty() && secondStack.empty();
    }
}