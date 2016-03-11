// 172. Factorial Trailing Zeroes
// Difficulty: Easy
// Given an integer n, return the number of trailing zeroes in n!.

// Note: Your solution should be in logarithmic time complexity.

public class Solution {
    public int trailingZeroes(int n) {
        int sum = 0;
        
        while (n > 4) {
            n /= 5;
            sum += n;
        }
        
        return sum;
    }
}