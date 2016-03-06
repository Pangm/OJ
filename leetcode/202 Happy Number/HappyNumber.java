// 202. Happy Number

// Difficulty: Easy
// Write an algorithm to determine if a number is "happy".

// A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

// Example: 19 is a happy number

// 1^2 + 9^2 = 82
// 8^2 + 2^2 = 68
// 6^2 + 8^2 = 100
// 1^2 + 0^2 + 0^2 = 1

import java.util.HashSet;
public class Solution {
    public boolean isHappy(int n) {
        boolean isH = false;
        HashSet<Integer> s = new HashSet<Integer>();
        int intermediate = 0;
        while (true) {
            intermediate = tran(n);
            
            if (intermediate == 1) {
                isH = true;
                break;
            } 
            if (s.contains(intermediate)) {
                break;
            } else {
                s.add(intermediate);
            }
            n = intermediate;
        }
        
        return isH;
    }
    
    public int tran(int n) {
        int sum = 0;
        int remainder = 0;
        
        while (n > 0) {
            remainder = n % 10;
            sum += remainder * remainder;
            n = n / 10;
        }
        
        return sum;
    }
}