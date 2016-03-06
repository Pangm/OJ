# 1. Two Sum
# Given an array of integers, return indices of the two numbers such that they add up to a specific target.

# You may assume that each input would have exactly one solution.
# Example:
#     Given nums = [2, 7, 11, 15], target = 9,

#     Because nums[0] + nums[1] = 2 + 7 = 9,
#     return [0, 1].

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        map = {}
        length = len(nums)
        for i in range(0, length):
            map[nums[i]] = i

        rtype = []
        for i in range(0, length):
            tmp = target - nums[i]
            if tmp in map and i != map[tmp]:
                rtype.append(i + 1)
                rtype.append(map[tmp] + 1)
                break
        return rtype
