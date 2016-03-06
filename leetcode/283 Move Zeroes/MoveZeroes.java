// 283. Move Zeroes
// Difficulty: Easy
// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

// Note:
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.

public class Solution {
    public void moveZeroes(int[] nums) {
        // solution A:
        /*
        int tail = nums.length;
        int interval = 0;
        int numZero = 0;
        int pos = 0;
        for (int i = 0; i < tail; i++) {
            if (nums[i] == 0) {
                // find non-zero pos
                for (pos = i + 1; pos < tail; pos++) {
                    if (nums[pos] != 0) {
                        // find non-zero
                        break;
                    }
                }
                
                // there is not any non-zero, stop.
                if (pos == tail) {
                    numZero++;
                    break;
                }
                
                interval = pos - i;
                numZero += interval;
                tail = nums.length - numZero;
                // move the nums
                for (int k = i; k < tail; k++) {
                    nums[k] = nums[k + interval];
                }
            }
        }
        
        for (int k = nums.length - numZero; k < nums.length; k++) {
            nums[k] = 0;
        }
        */

        // solution B:
        int posZero = -1;
        
        // find the first zero pos.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                posZero = i;
                break;
            }
        }
        if (posZero == -1) {
            // There is no zero number.
            return;
        }
        // find non-zero and fill into zero pos.
        for (int k = posZero + 1; k < nums.length; k++) {
            if (nums[k] != 0) {
                // find non-zero
                nums[posZero] = nums[k];
                posZero++;
            }
        }
        
        for (int k = posZero; k < nums.length; k++) {
            nums[k] = 0;
        }
        
    }
}