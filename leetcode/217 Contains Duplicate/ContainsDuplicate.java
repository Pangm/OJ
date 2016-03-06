// 217. Contains Duplicate
// Difficulty: Easy
// Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

import java.util.Arrays;
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] == nums[j]) {
        //             return false;
        //         }
        //     }
        // }
        // return true;
        
        // quicksort(nums, 0, nums.length-1);
        
        Arrays.sort(nums);
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
        
    }
    
    private void quicksort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        
        if (end - start <= 7) {
            insertedSort(nums, start, end);
        } else {
        
            int povitPos = getPovitPos(nums, start, end);
            
            int povit = nums[povitPos];
            nums[povitPos] = nums[end];
            nums[end] = povit;
            
            int l = start;
            int r = end - 1;
            
            while (true) {
                int i, j;
                for(i = l; i <= r && nums[i] <= povit; i++);
                for(j = r; j >= l && nums[j] > povit; j--);
                if (i < j) {
                    swap(nums, i, j);
                    l = i + 1;
                    r = j - 1;
                } else {
                    break;
                }
            }
            swap(nums, r, end);
            
            quicksort(nums, start, r);
            quicksort(nums, r + 1, end);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private int getPovitPos(int[] nums, int start, int end) {
        return (start + end) / 2;
    }
    
    private void insertedSort(int[] nums, int start, int end) {
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if (tmp < nums[j]) {
                    swap(nums, j, j + 1);
                } else {
                    break;
                }
            }
        }
    }
}