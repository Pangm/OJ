// 169. Majority Element
// Difficulty: Easy
// Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

// You may assume that the array is non-empty and the majority element always exist in the array.

import java.util.Arrays;
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        
        int m = nums.length / 2;
        int n = nums.length - m;
        for (int i = 0; i < n; i++) {
            if (nums[i] == nums[i + m]) {
                return nums[i];
            }
        }
        
        return 0;
        
    }
}