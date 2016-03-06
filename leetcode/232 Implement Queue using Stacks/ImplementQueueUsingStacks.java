// 232. Implement Queue using Stacks
// Difficulty: Easy
// Implement the following operations of a queue using stacks.

// 	push(x) -- Push element x to the back of queue.
// 	pop() -- Removes the element from in front of queue.
// 	peek() -- Get the front element.
// 	empty() -- Return whether the queue is empty.
// Notes:
// 	You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
// 	Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
// 	You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).


import java.util.Stack;
class MyQueue {
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
    public void pop() {
        if (firstStack.empty() && secondStack.empty()) {
            return;
        }
        
        while(!firstStack.empty()) {
            int value = firstStack.peek();
            secondStack.push(value);
            firstStack.pop();
        }
        
        secondStack.pop();
        
        if (!secondStack.empty()) {
            front = secondStack.peek();
        }
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