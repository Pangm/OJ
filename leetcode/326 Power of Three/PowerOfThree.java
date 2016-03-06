// 326. Power of Three
// Difficulty: Easy
// Given an integer, write a function to determine if it is a power of three.

// Follow up:
// Could you do it without using any loop / recursion?

import java.lang.Math;
public class Solution {
    public boolean isPowerOfThree(int n) {
        // Solution A:
        // return n > 0 && Math.pow(3, (int) (Math.log(Integer.MAX_VALUE) / Math.log(3))) % n == 0;
        
        // Solution B:
        // 因为log(243) gave me 4.99999
        return  n > 0 && Math.log10(n) / Math.log10(3) % 1 == 0;
        
    }
}