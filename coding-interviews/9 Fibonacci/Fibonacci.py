# -*- coding:utf-8 -*-
class Solution:
    # Solution A
    def FibonacciA(self, n):
        # write code here
        if n == 0:
            return 0
        
        f0, f1 = (0, 1)
        
        for i in xrange(1, n):
            tmp = f0 + f1
            f0, f1 = (f1, tmp)
            
        return f1
    
    # Solution B
    def Fibonacci(self, n):
        # write code here
        
        if n == 0:
            return 0
        if n == 1:
            return 1
        
        matric = [[1, 1], [1, 0]]        
              
        return (self.MatricPow(matric, n-1))[0][0]
        
    def MatricPow(self, matric, n):
        
        if n == 1:
            return matric
        
        result = self.MatricPow(matric, n >> 1)
        result = self.MatricMultipy(result, result, 2)
            
        if n & 1 == 1:
            result = self.MatricMultipy(result, matric, 2)
        return result
        
    def MatricMultipy(self, matric1, matric2, m):
        result = [[0 for i in xrange(m)],
                  [0 for i in xrange(m)]]
        for i in xrange(m):
            for j in xrange(m):
                for k in xrange(m):
                    result[i][j] += matric1[i][k] * matric2[k][j]
        
        return result
        
if __name__ == '__main__':
    s = Solution()
    print s.Fibonacci(4)