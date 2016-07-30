67. Add Binary  QuestionEditorial Solution  My Submissions
Difficulty: Easy
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

public class Solution {
    public String addBinary(String a, String b) {
        
        if (a == null || b == null) {
            return "";
        }
        
        // longer string.
        String ls;
        // shorter string.
        String ss;
        
        if (a.length() > b.length()) {
            ls = a;
            ss = b;
        } else {
            ls = b;
            ss = a;
        }
        
        StringBuilder sb = new StringBuilder();
        
        int flag = 0;
        int iL = ls.length() - 1;
        int iS = ss.length() - 1;
        for (; iS >= 0; iS--, iL--) {
            if (ls.charAt(iL) == ss.charAt(iS)) {
                sb.insert(0, flag);
                if (ls.charAt(iL) == '1') {
                    flag = 1;
                } else {
                    flag = 0;
                }
            } else {
                if (flag == 1) {
                    sb.insert(0, 0);
                    flag = 1;
                } else {
                    sb.insert(0, 1);
                    flag = 0;
                }
            }
        }
        
        // 
        for (; iL >= 0; iL--) {
            if (ls.charAt(iL) == '0') {
                sb.insert(0, flag);
                flag = 0;
            } else {
                if (flag == 1) {
                    sb.insert(0, 0);
                    flag = 1;
                } else {
                    sb.insert(0, 1);
                    flag = 0;
                }
            }
            
        }
        
        if (flag == 1) {
            sb.insert(0, 1);
        }
        
        return sb.toString();
        
    }
}