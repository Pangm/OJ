// 27. Remove Element
// Difficulty: Easy
// Given an array and a value, remove all instances of that value in place and return the new length.

// The order of elements can be changed. It doesn't matter what you leave beyond the new length.

public class Solution {
    public int removeElement(int[] nums, int val) {
        int tail = nums.length;
        int i = 0;
        while (i < tail) {
            if (nums[i] == val) {
                nums[i] = nums[tail - 1];
                tail--;
            } else {
                i++;
            }
        }
        
        return tail;
    }
}