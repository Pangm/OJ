// 8. String to Integer (atoi)
// Difficulty: Easy

// Implement atoi to convert a string to an integer.

// Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

// Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front. 

// Requirements for atoi:

// The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

// The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

// If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

// If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.


public class Solution {
    public int myAtoi(String str) {
        // return Integer.parseInt(str);
        
        if (str == null) {
            return 0;
        }
        
        int result = 0;
        int start = 0;
        int length = str.length();
        boolean signFound = false;
        boolean negative = false;
        char c;
        int digit = 0;
        if (str.length() > 0) {
            c = str.charAt(start);
            while (start < length) {
                c = str.charAt(start);
                if (!Character.isDigit(c) && !signFound) { 
                    // "+" or "-"
                    if (c == '-' || c == '+') {
                        if (signFound) {
                            return 0;
                        } else {
                            signFound = true;
                        }
                        
                        if (c == '-') {
                            negative = true;
                        }
                    } else if (c == ' ') {
                        
                    } else {
                        return 0;
                    }
                    start++;
                } else {
                    break;
                }
            }
            for (int i = start; i < length; i++) {
                c = str.charAt(i);
            
                digit = c - '0';
                
                if (digit < 0 || digit > 9) {
                    break;
                } else {
                    if ((result < Integer.MAX_VALUE / 10)
                            || (result  == Integer.MAX_VALUE / 10 && digit <= Integer.MAX_VALUE % 10))  {
                        result = result * 10 + Character.digit(c, 10);
                    } else {
                        return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    }
                }
            }
        }
        
        return negative ? -result : result;
    }
}