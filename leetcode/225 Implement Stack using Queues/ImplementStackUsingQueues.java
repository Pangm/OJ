// 225. Implement Stack using Queues
// Difficulty: Easy
// Implement the following operations of a stack using queues.

// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// empty() -- Return whether the stack is empty.
// Notes:
// You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
// Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
// You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

class MyStack {
    
    Queue<Integer> q = new LinkedList<Integer>();
    Queue<Integer> qVice = new LinkedList<Integer>();
    int last = 0;
    boolean flag = true;
    int size = 0;
    
    // Push element x onto stack.
    public void push(int x) {
        size ++;
        q.offer(x);
        last = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue<Integer> tmp = q;
        q = qVice;
        qVice = tmp;
        flag = false;
        
        int qViceSize = size;
        while (qViceSize > 2) {
            q.offer(qVice.remove());
            qViceSize--;
        }
        
        last = qVice.remove();
        q.offer(last);
        if (qVice.isEmpty()) {
            q.remove();
        } else {
            qVice.remove();
        }
        size--;
    }

    // Get the top element.
    public int top() {
        return last;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return size == 0;
    }
}