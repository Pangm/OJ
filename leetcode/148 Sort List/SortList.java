// 148. Sort List
// Difficulty: Medium
// Sort a linked list in O(n log n) time using constant space complexity.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
    
        int len = 0;
        for (ListNode node = head; node != null; node = node.next, len++);
        
        len = len / 2 - 1;
        
        ListNode node = head;
        for (int i = 0; i < len; i++, node = node.next);
        
        ListNode r = node.next;
        node.next = null;
        
        return mergeList(sortList(head), sortList(r));
    }
    
    private ListNode mergeList(ListNode l, ListNode r) {
        ListNode head;
        if (l == null) {
            return r;
        }
        if (r == null) {
            return l;
        }
        
        // l first element is smaller than r first element.
        if (l.val < r.val) {
            head = l;
        } else {
            // swap r, l
            head = r;
            r = l;
            l = head;
        }
        
        ListNode last = head;
        l = head.next;
        boolean isWait = false;
        while(r != null) {
            if (l == null) {
                // reach the l tail
                last.next = r;
                break;
            } else {
                
                if (r.val < l.val ) {
                    isWait = true;
                    last.next = r;
                    last = last.next;
                    r = r.next;
                } else {
                    if (isWait) {
                        last.next = l;
                        isWait = false;
                    }
                    last = l;
                    l = l.next;
                }
            }
        }
        if (isWait) {
            last.next = l;
        }
        
        return head;
    }
    
}
