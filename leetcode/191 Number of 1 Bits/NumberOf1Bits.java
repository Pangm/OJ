// 191. Number of 1 Bits
// Difficulty: Easy
// Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

// For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        
        // solution A:
        // int b = 1;
        // for (int i = 0; i < 32; i++) {
        //     cnt += ((n & (b << i)) == 0) ? 0 : 1;
        // }
        
        while (n != 0) {
            n = n & (n - 1);
            ++cnt;
        }
        
        return cnt;
    }
}