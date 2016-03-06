// 206. Reverse Linked List
// Difficulty: Easy
// Reverse a singly linked list.

// click to show more hints.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        
        ListNode node = head;
        
        // Solution A:
        
        // ListNode newCurNode = null;
        // while (node != null) {
        //     newCurNode = new ListNode(node.val);
        //     newCurNode.next = newHead;
        //     newHead = newCurNode;
            
        //     node = node.next;
        // }
        
        // return newHead;
        
        // Solution B:
        
        if (head == null) {
            return head;
        }
        
        ListNode nextNode = null;
        while (node.next != null) {
            nextNode = node.next;
            node.next = newHead;
            newHead =  node;
            node = nextNode;
        }
        
        node.next = newHead;
        newHead = node;
        
        return newHead;
        
    }
}