# -*- coding:utf-8 -*-


class Solution:
    def jumpFloor(self, number):
        # write code here
        # return self.jumpFloor_loop(number)
        return self.jumpFloor_formula(number)
        
    def jumpFloor_loop(self, number):
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
    
    def jumpFloor_recursion(self, number):
        # write code here
        if number == 0:
            return 1
        elif number == 1:
            return 1
        else:
            return self.jumpFloor_recursion(number - 1) + self.jumpFloor_recursion(number - 2)
    
    def jumpFloor_formula(self, number):
        # write code here
        if number == 0:
            return 1
        elif number == 1:
            return 1
        else:
            base = [[1, 1],
                    [1, 0]]
            
            f01 = [1, 1]
            
            m = self.MatrixPow(base, number - 1)
            
            r = 0
            
            for i in xrange(len(m)):
                r += f01[i] * m[i][0]
                
            return r
    
    def MatrixPow(self, base, number):
        #if number == 0:
            # impossible
            
        if number == 1:
            return base
        
        result = self.MatrixPow(base, number >> 1)
        
        result = self.MatrixMultipy(result, result)
        
        if (number & 1) == 1:
            result = self.MatrixMultipy(result, base)
        
        return result
        
    def MatrixMultipy(self, m1, m2):
        rows = len(m1)
        cols = len(m2[0])
        result = [[0 for col in xrange(cols)] for row in xrange(rows)]
        
        for i in xrange(rows):
            for j in xrange(cols):
                for k in xrange(len(m2)):
                    result[i][j] += m1[i][k] * m2[k][j]
        
        return result
        
    
if __name__ == '__main__':
	s = Solution()

	print s.jumpFloor(4)