// 83. Remove Duplicates from Sorted List
// Difficulty: Easy
// Given a sorted linked list, delete all duplicates such that each element appear only once.

// For example,
// Given 1->1->2, return 1->2.
// Given 1->1->2->3->3, return 1->2->3.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // public ListNode deleteDuplicates(ListNode head) {
        ListNode flagNode = head;
        ListNode node = flagNode;
        
        while (flagNode != null && flagNode.next != null) {
            node = flagNode.next;
            while (node != null && flagNode.val == node.val) {
                node = node.next;
            }
            
            flagNode.next = node;
            
            flagNode = flagNode.next;
        }
        
        return head;
    }
}