# 7. Reverse Integer
# Difficulty: Easy
# Reverse digits of an integer.

# Example1: x = 123, return 321
# Example2: x = -123, return -321

class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        s = str(x)
        print s[0]
        print len(s)
        if s[0] == '-':
            s = s[0] + s[1:][::-1]
        else:
            s = s[::-1]
        ret = int(s)
        if abs(ret) >= 2147483648:
            return 0
        else:
            return ret