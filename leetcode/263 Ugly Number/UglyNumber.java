// 263. Ugly Number
// Difficulty: Easy
// Write a program to check whether a given number is an ugly number.

// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

// Note that 1 is typically treated as an ugly number.

public class Solution {
    public boolean isUgly(int num) {
        // Solution A:
        // if (num == 1 ) {
        //     return true;
        // } else {
        //     if (num <= 0) {
        //         return false;
        //     }
            
        //     if (num % 2 == 0 ) {
        //         return isUgly(num / 2);
        //     } else if (num % 3 == 0 ) {
        //         return isUgly(num / 3);
        //     } else if (num % 5 == 0 ) {
        //         return isUgly(num / 5);
        //     } else {
        //         return false;
        //     }
        // }
        
        // Solution B:
        if (num <= 0) {
            return false;
        }
        
        boolean isU = true;
        
        while (num != 0) {
            if (num == 1 ) {
                break;
            } else if (num % 2 == 0 ) {
                num /= 2;
            } else if (num % 3 == 0 ) {
                num /= 3;
            } else if (num % 5 == 0 ) {
                num /= 5;
            } else {
                // false
                isU = false;
                break;
            }
        }
        
        return isU;
    }
}