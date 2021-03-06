// 从尾到头打印链表
// 题目描述

// 输入一个链表，从尾到头打印链表每个节点的值。 
// 输入描述:
// 输入为链表的表头

// 输出描述:
// 输出为需要打印的“新链表”的表头

/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> list = printListFromTailToHead(listNode.next);
        list.add(listNode.val);
        
        return list;
    }
}