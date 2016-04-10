// 复杂链表的复制
// 题目描述

// 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。

/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null) {
            return null;
        }
        
        RandomListNode node = pHead;
        // 1. copy node
        while (node != null) {
            RandomListNode nodeClone = new RandomListNode(node.label);
            nodeClone.next = node.next;
            nodeClone.random = null;
            node.next = nodeClone;
            
            node = nodeClone.next;
        }
        
        // 2. copy random record
        node = pHead;
        while (node != null) {
            RandomListNode nodeClone = node.next;
            if (node.random != null) {                
                nodeClone.random = node.random.next;
            }
            
            node = nodeClone.next;
        }
        
        // 3. delete origin node
        RandomListNode head = pHead.next;
        node = pHead;
        while (node != null) {
            RandomListNode nodeClone = node.next;
            node.next = nodeClone.next;
            
            if (nodeClone.next != null) {
            	nodeClone.next = nodeClone.next.next;
            }
            
            node = node.next;
        }
        
        return head;
    }
}