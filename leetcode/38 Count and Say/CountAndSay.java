/*38. Count and Say  QuestionEditorial Solution  My Submissions
Difficulty: Easy
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.*/

public class Solution {
    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }
        
        if (n == 1) {
            return "1";
        }
        
        String targetStr = "1";
        
        for (int i = 0; i < n - 1; i++) {
            targetStr = buildString(targetStr);
        }
        
        return targetStr;
    }
    
    private String buildString(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        
        char lastChar = str.charAt(0);
        int counter = 1;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < str.length(); i++) {
            if (lastChar != str.charAt(i)) {
                sb.append(counter).append(lastChar);
                lastChar = str.charAt(i);
                counter = 1;
            } else {
                counter++;
            }
        }
        // the last char.
        sb.append(counter).append(lastChar);
        
        return sb.toString();
    }
}