# 二维数组中的查找
# 题目描述

# 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。 
# 输入描述:
# array： 待查找的二维数组
# target：查找的数字


# 输出描述:
# 查找到返回true，查找不到返回false

# -*- coding:utf-8 -*-
class Solution:
    # array 二维列表
    def Find(self, array, target):
        # write code here
        
        if array is None or len(array) == 0:
            return False;
        
        rows = len(array)
        cols = len(array[0])
        
        i, j = (0, cols - 1)
        
        while i < rows and j >= 0:
            if array[i][j] == target:
                return True
            elif array[i][j] > target:
                j -= 1
            else:
                i += 1
       	
        return False
        