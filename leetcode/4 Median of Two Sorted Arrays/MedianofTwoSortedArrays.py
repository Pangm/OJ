# 4. Median of Two Sorted Arrays
# Difficulty: Hard
# There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        nums = []

        m, n, i, j = len(nums1), len(nums2), 0, 0

        while True:
            if i == m and j == n:
                break
            elif i != m and j != n:
                if nums1[i] < nums2[j]:
                    tmp = nums1[i]
                    i += 1
                else:
                    tmp = nums2[j]
                    j += 1
            elif j == n:
                tmp = nums1[i]
                i += 1
            else: # i == m
                tmp = nums2[j]
                j += 1
            nums.append(tmp)

        if (m + n) % 2 == 0:
            index = (m + n) / 2
            median = (nums[index - 1] + nums[index]) / 2.0
        else:
            median = nums[(m + n) / 2]

        return median