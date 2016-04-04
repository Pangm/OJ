import java.util.Stack;
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        /*Stack<ListNode> s = new Stack<ListNode>();
        
        // head is null.
        if (head == null) {
            return null;
        }
        
        ListNode node = head;
        while (node != null) {
            s.push(node);
            node = node.next;
        }
        
        // record the head.
        head = s.pop();
        node = head;
        
        while (!s.empty()) {
            node.next = s.pop();
            node = node.next;
        }
        
        return head;*/
        
        
        // Solution A: loop
        // head is null
        /*if (head == null) {
            return null;
        }
        
        ListNode nodePrev = null;
        ListNode node = head;
        
        while (node != null) {
            ListNode nodeNext = node.next;
            if (nodeNext == null) {
                head = node;
            }
            node.next = nodePrev;
            nodePrev = node;
            node = nodeNext;
        }
        
        return head;
        */
        
        // Solution B: recursion
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode nodeNext = head.next;
        head.next = null;
        ListNode newHead = ReverseList(nodeNext);
        nodeNext.next = head;
        return newHead;
    }
}