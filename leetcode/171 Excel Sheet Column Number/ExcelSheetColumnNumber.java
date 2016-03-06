// 171. Excel Sheet Column Number
// Difficulty: Easy
// Related to question Excel Sheet Column Title

// Given a column title as appear in an Excel sheet, return its corresponding column number.

// For example:

//     A -> 1
//     B -> 2
//     C -> 3
//     ...
//     Z -> 26
//     AA -> 27
//     AB -> 28 

import java.lang.*;
public class Solution {
    public int titleToNumber(String s) {
        int number = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            // number = number * 26 + (s.charAt(i) - 'A' + 1);
            number += (s.charAt(i) - 'A' + 1) * (int) Math.pow(26, len-i-1);
        }
        return number;
    }
}