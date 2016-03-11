// 21. Merge Two Sorted Lists
// Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList;
        ListNode node;
        
        if (l1 == null) {
            return l2;
        } 
        
        if (l2 == null) {
            return l1;
        }
        
        if (l1.val < l2.val) {
            newList = l1;
            l1 = l1.next;
        } else {
            newList = l2;
            l2 = l2.next;
        }
        
        node = newList;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        
        if (l1 == null) {
            node.next = l2;
        } 
        
        if (l2 == null) {
            node.next = l1;
        }
        
        return newList;
    }
}