# 5. Longest Palindromic Substring
# Difficulty: Medium
# Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

# O(n)
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        ns = self.__preprocess(s)
        nsLen = len(ns)
        center, right = 0, 0
        max, pos = 0, 0
        p = [1]
        for i in xrange(1, nsLen):
            j = 2 * center - i

            if right < i:
                p.append(1)
            else:
                p.append(min(right - i, p[j]))

            while i - p[i] > 0 and i + p[i] < nsLen and ns[i - p[i]] == ns[i + p[i]]:
                p[i] += 1

            if i + p[i] > right:
                center = i
                right = center + p[i]

            if max < p[i]:
                max = p[i]
                pos = i

        return s[(pos - max) / 2:(pos + max) / 2 -1]

    def __preprocess(self, s):
        ns = '$#' + '#'.join(s) + '#'
        return ns