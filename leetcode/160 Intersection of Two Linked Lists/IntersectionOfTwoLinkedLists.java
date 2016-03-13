// 160. Intersection of Two Linked Lists
// Difficulty: Easy
// Write a program to find the node at which the intersection of two singly linked lists begins.


// For example, the following two linked lists:

// A:          a1 → a2
//                    ↘
//                      c1 → c2 → c3
//                    ↗            
// B:     b1 → b2 → b3
// begin to intersect at node c1.


// Notes:

// If the two linked lists have no intersection at all, return null.
// The linked lists must retain their original structure after the function returns.
// You may assume there are no cycles anywhere in the entire linked structure.
// Your code should preferably run in O(n) time and use only O(1) memory.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// Solution A： Memory Limit Exceeded
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         if (headA == null || headB == null) {
//             return null;
//         }
        
//         int lenA = 0;
//         int lenB = 0;
//         ListNode node = headA;
//         while(node != null) {
//             node = node.next;
//             lenA++;
//         }
//         node = headB;
//         while(node != null) {
//             node = node.next;
//             lenB++;
//         }
        
//         if (lenA < lenB) {
//             node = headB;
//             headB = headA;
//             headA = node;
//         }
        
//         int m = Math.abs(lenA - lenB);
//         while (m > 0) {
//             headA = headA.next;
//             m--;
//         }
        
//         while(headA != headB && headA != null) {
//             headA = headA.next;
//             headB = headB.next;
//         }
        
//         return headA;
//     }
// }

//Solution B
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        
        while(nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        
        return nodeA;
    }
}