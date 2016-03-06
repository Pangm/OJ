// 328. Odd Even Linked List
// Difficulty: Easy
// Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

// You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

// Example:
// Given 1->2->3->4->5->NULL,
// return 1->3->5->2->4->NULL.

// Note:
// The relative order inside both the even and odd groups should remain as it was in the input. 
// The first node is considered odd, the second node even and so on ...

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = null;
        ListNode evenHead = null;
        ListNode curOddNode = null;
        ListNode curEvenNode = null;
        ListNode node = null;
        int index = 1;
        
        node = head;
    
        while (node != null) {
            if (index % 2 == 0) {
                // Even
                if (curEvenNode == null) {
                    evenHead = node;
                    curEvenNode = evenHead;
                } else {
                    curEvenNode.next = node;
                    curEvenNode = curEvenNode.next;
                }
            } else {
                // Odd
                if (curOddNode == null) {
                    oddHead = node;
                    curOddNode = oddHead;
                } else {
                    curOddNode.next = node;
                    curOddNode = curOddNode.next;
                }
            }
             
            node = node.next;
            index++;
        }
        
        if (curOddNode != null) {
            curOddNode.next = null;
        }
        
        if (curEvenNode != null) {
            curEvenNode.next = null;
        }
        
        if (oddHead == null) {
            return evenHead;
        } else {
            curOddNode.next = evenHead;
        }
        
        return oddHead;
    }
    
}