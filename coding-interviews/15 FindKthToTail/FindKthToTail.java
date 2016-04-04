// 链表中倒数第k个结点
// 题目描述
// 输入一个链表，输出该链表中倒数第k个结点。

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        // head is null.
        if (head == null) {
            return null;
        }
        
        // find k-th node 
        ListNode kNode = head;
        
        while (k != 1 && kNode != null) {
            kNode = kNode.next;
            --k;
        }
        
        // number of nodes < k
        if (kNode == null) {
            return null;
        }
        
        ListNode node = head;
        while (kNode.next != null) {
            node = node.next;
            kNode = kNode.next;
        }
        
        return node;
    }
}