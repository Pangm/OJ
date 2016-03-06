# 3. Longest Substring Without Repeating Characters
# Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        locations = {}

        maxLen = 0
        left = 0
        length = len(s)
        for i in range(0, length):
            # index = locations.setdefault(s[i], i)

            if s[i] in locations:
                location = locations[s[i]] + 1
                if location > left:
                    left = location
            locations[s[i]] = i
            maxLen = max(maxLen, i - left + 1)

        return maxLen