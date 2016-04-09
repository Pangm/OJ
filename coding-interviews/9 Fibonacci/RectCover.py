# 矩形覆盖
# 题目描述

# 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
# -*- coding:utf-8 -*-
class Solution:
    def rectCover(self, number):
        # write code here
        if number == 0:
            return 1
        elif number == 1:
            return 1
        else:
            prevF, f = (1, 1)

            for i in xrange(2, number + 1):
                tmp = f
                f += prevF
                prevF = tmp

            return f