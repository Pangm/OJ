# -*- coding:utf-8 -*-
import math
class Solution:
    def jumpFloorII(self, number):
        # f(n) = f(n-1) + f(n-2) + ... + f(1)
        # f(n-1) = f(n-2) + ... + f(1)
        # f(n) = 2f(n-1)
        # write code here
        if number == 0:
            return 1
        
        return int(math.pow(2, number - 1))