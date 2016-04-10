# 旋转数组的最小数字
# 题目描述

# 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减序列的一个旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。

# -*- coding:utf-8 -*-
class Solution:
    def minNumberInRotateArray(self, rotateArray):
        # write code here
        length = len(rotateArray)
        if length == 0:
            return 0
         
        left, right = (0, length - 1)
         
        mid = left
        while rotateArray[left] >= rotateArray[right]:
            if right - left == 1:
                mid = right
                break
                 
            mid = (left + right) >> 1
             
            if rotateArray[left] == rotateArray[mid] and rotateArray[mid] == rotateArray[right]:
                min = rotateArray[left]
                for i in xrange(left+1, right+1):
                    if min > rotateArray[i]:
                        min = rotateArray[i]
                return min                       
             
            if rotateArray[mid] >= rotateArray[left]:
                left = mid
            elif rotateArray[mid] <= rotateArray[right]:
                right = mid
 
        return rotateArray[mid]