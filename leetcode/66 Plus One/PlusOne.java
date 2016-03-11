// 66. Plus One
// Difficulty: Easy
// Given a non-negative number represented as an array of digits, plus one to the number.

// The digits are stored such that the most significant digit is at the head of the list.

public class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        boolean flag = false;
        
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                flag = false;
                digits[i] += 1;
                break;
            } else {
                flag = true;
                digits[i] = 0;
            } 
        }
        
        if (flag) {
            int[] newDigits = new int[length + 1];
            newDigits[0] = 1;
            return newDigits;
        } else {
            return digits;
        }
    }
}