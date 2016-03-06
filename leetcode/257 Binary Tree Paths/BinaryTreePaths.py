# 257. Binary Tree Paths
# Difficulty: Easy
# Given a binary tree, return all root-to-leaf paths.

# For example, given the following binary tree:

#    1
#  /   \
# 2     3
#  \
#   5
# All root-to-leaf paths are:

# ["1->2->5", "1->3"]


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {string[]}
    def binaryTreePaths(self, root):
        nodeArray = []
        paths = []
        path = []
        node = root
        if node == None:
            return []
        parent = node
        while True:
            if node == None:
                if len(nodeArray) == 0:
                    break
                parent = nodeArray.pop()
                node = parent.right
                tmpPath = []
                for n in path:
                    if n != parent:
                        tmpPath.append(n)
                    else:
                        break
                tmpPath.append(parent)
                path = tmpPath
                continue
            # leaf node
            if node.right == None and node.left == None:
                # path.append(node)
                tmpPathVal = []

                for n in path:
                    if n != parent:
                        tmpPathVal.append(str(n.val))
                        # tmpPath.append(n)
                    else:
                        break
                # tmpPath.append(parent)
                # path = tmpPath
                if parent != node:
                    tmpPathVal.append(str(parent.val))
                    # path.pop()
                tmpPathVal.append(str(node.val))
                pathString = "->".join(tmpPathVal)
                paths.append(pathString)

                # node backtrack
                if len(nodeArray) == 0:
                    break
                parent = nodeArray.pop()

                tmpPath = []
                for n in path:
                    if n != parent:
                        tmpPath.append(n)
                    else:
                        break
                tmpPath.append(parent)
                path = tmpPath

                node = parent.right
                # path.pop()
            else:
                parent = node
                if node.left != None:
                    nodeArray.append(node)
                    path.append(node)
                    node = node.left
                elif node.right != None:
                    # don't store node
                    # nodeArray.append(node)
                    path.append(node)
                    node = node.right

        return paths