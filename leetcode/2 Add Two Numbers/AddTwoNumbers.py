# 2. Add Two Numbers
# Difficulty: Medium
# You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

# Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
# Output: 7 -> 0 -> 8

# # Definition for singly-linked list.
# # class ListNode(object):
# #     def __init__(self, x):
# #         self.val = x
# #         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        
        node1 = l1
        node2 = l2
        s = 0
        head = None
        node = None
        
        while True:
            if node1 != None and node2 != None:
                tmp = node1.val + node2.val + s
                s = tmp / 10
                node1 = node1.next
                node2 = node2.next
            elif node1 == None and node2 ==None:
                if s != 0:
                    node.next = ListNode(s)
                break
            else:
                if node1 != None:
                    tmpNode = node1
                    node1 = node1.next
                else:
                    tmpNode = node2
                    node2 = node2.next
                    
                tmp = tmpNode.val + s
                s = tmp / 10
                node.next = ListNode(tmp % 10)
            
            if head == None:
                head = ListNode(tmp % 10)
                node = head
            else:
                node.next = ListNode(tmp % 10)
                node = node.next
                
        return head
                    
                