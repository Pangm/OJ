// 231. Power of Two
// Difficulty: Easy
// Given an integer, write a function to determine if it is a power of two.

import java.lang.Math;
public class Solution {
    public boolean isPowerOfTwo(int n) {
        // Solution A:
        // return n > 0 && Math.pow(2, Integer.SIZE) % n == 0; 
        // Solution B:
        return n > 0 && Math.log10(n) / Math.log10(2) % 1 == 0; 
    }
}