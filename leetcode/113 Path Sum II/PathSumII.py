# 113. Path Sum II
# Difficulty: Medium
# Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

# For example:
# Given the below binary tree and sum = 22,
#               5
#              / \
#             4   8
#            /   / \
#           11  13  4
#          /  \    / \
#         7    2  5   1
# return
# [
#    [5,4,11,2],
#    [5,8,4,5]
# ]


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def pathSum(self, root, s):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        self.paths = []
        self.path = []
        backtrack(root, self.path, self.paths)
        ret = []
        for p in self.paths:
            if s == sum(p):
                ret.append(p)
        return ret


def is_leaf(node):
    if node.left == None and node.right == None:
        return True
    else:
        return False

def backtrack(root, path, paths):
    if root == None:
        return
    else:
        path.append(root.val)
    if is_leaf(root):
        paths.append(path)
    else:
        length = len(path)
        if root.left != None:
            backtrack(root.left, path, paths)
        path = path[:length]
        if root.right != None:
            backtrack(root.right, path, paths)
