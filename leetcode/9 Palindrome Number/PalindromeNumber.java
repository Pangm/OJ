// 9. Palindrome Number
// Difficulty: Easy
// Determine whether an integer is a palindrome. Do this without extra space.

// click to show spoilers.

// Some hints:
// Could negative integers be palindromes? (ie, -1)

// If you are thinking of converting the integer to string, note the restriction of using extra space.

// You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

// There is a more generic way of solving this problem.

// Solution A: beat 5.84%
// public class Solution {
//     public boolean isPalindrome(int x) {
//         if (x < 0) {
//             return false;
//         }
        
//         int length = 1;
//         int n = x;
        
//         // get x's length;
//         while ((n /= 10) != 0) {
//             length++;
//         }
//         boolean isP = true;
//         int mid = (length + 1) / 2;
//         int i = 0;
//         while (i < mid) {
//             if (getValByPos(x, mid - i) == getValByPos(x, length + 1 - (mid - i))) {
//                 i++;
//             } else {
//                 isP = false;
//                 break;
//             }
//         }
        
//         return isP;
//     }
    
//     private int getValByPos(int x, int pos) {
//         int val = 0;
        
//         val = x / (int) Math.pow(10, pos - 1);
//         val %= 10;
        
//         return val;
//     }
// }

// Solution B: beat 46.14%
// public class Solution {
//     public boolean isPalindrome(int x) {
//         // Negative number is not
//         if (x < 0) {
//             return false;
//         }
        
//         // sigal number is palindrome
//         if (x < 10) {
//             return true;
//         }
        
//         int length = 1;
//         int n = x;
        
//         // get x's length;
//         while ((n /= 10) != 0) {
//             length++;
//         }
//         boolean isP = true;
//         int mid = (length + 1) / 2;
        
//         int base = (int) Math.pow(10, mid);
        
//         // get left part.
//         int leftPart = x / base;
//         // get right part.
//         int right = 0;
//         if (length % 2 == 0) {
//             right = x % base;
//         } else {
//             base /= 10;
//             right = x % base;
//         }
//         // reverse left part.
//         int left = 0;
//         while (leftPart != 0) {
//             left = left * 10  + leftPart % 10;
//             leftPart /= 10;
//         }
        
//         // compare left and right' reverse
//         if (left == right) {
//             return true;
//         } else {
//             return false;
//         }
//     }
// }

// Solution C: beat 74.26%
public class Solution {
    public boolean isPalindrome(int x) {
        // Negative number is not
        if (x < 0) {
            return false;
        }
        
        int n = x;
        long reverse = 0;
        while (n != 0) {
            reverse = reverse * 10  + n % 10;
            n /= 10;
        }
        
        if (reverse > Integer.MAX_VALUE) {
        	// overflow
            return false;
        } else {
        	// compare x and x' reverse
        	return x == reverse;
        }

        // or like that 
        int reverse = 0;
        while (n != 0) {
            reverse = reverse * 10  + n % 10;
            n /= 10;
        }
        
        if (reverse < 0) {
        	// overflow
            return false;
        } else {
        	// compare x and x' reverse
            return x == reverse;
        }
    }
}