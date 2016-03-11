// 26. Remove Duplicates from Sorted Array
// Difficulty: Easy
// Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

// Do not allocate extra space for another array, you must do this in place with constant memory.

// For example,
// Given input array nums = [1,1,2],

// Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

//Solution A:
// public class Solution {
//     public int removeDuplicates(int[] nums) {
//         int length = nums.length;
//         int i = length - 2;
//         while (i >= 0) {
//             if (nums[i] == nums[i+1]) {
//                 for (int j = i; j + 1 < length; j++) {
//                     nums[j] = nums[j+1];
//                 }
//                 length--;
//             }
//             i--;
//         }
        
//         return length;
//     }
// }

//Solution B:
public class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int curLen = 0;
        for (int i = 1; i < length; i ++) {
            if (nums[i-1] < nums[i]) {
                nums[++curLen] = nums[i];
            }
        }
        
        return curLen + 1;
    }
}