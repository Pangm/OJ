# 198. House Robber
# Difficulty: Easy
# You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

# Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

public class Solution {
    public int rob(int[] nums) {
        int sumY = 0;
        int lastSumY = 0;
        int lastSumN = 0;
        int sumN = 0;
        
        for (int k = nums.length - 1; k >= 0; k--) {
            sumY = nums[k] + lastSumN;
            sumN = Math.max(lastSumN, lastSumY);
            lastSumY = sumY;
            lastSumN = sumN;
        }
        
        return Math.max(sumY, sumN);
    }
}