/*20. Valid Parentheses  QuestionEditorial Solution  My Submissions
Difficulty: Easy
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.*/

public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Stack stack = new Stack();
        
        for (int i = 0; i < s.length(); i++) {
            if (isLeftParentheses(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (isRightParentheses(s.charAt(i))) {
                if (stack.empty()) {
                    return false;
                }
                char c = (char) stack.pop();
                if (s.charAt(i) == ')') {
                    if (c != '(') {
                        return false;
                    }
                } else {
                    // ']'
                    if (c != '[') {
                        return false;
                    }
                }
            }
        }
        
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
    
    
    private boolean isLeftParentheses(char c) {
        if (c == '(' || c == '[') {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isRightParentheses(char c) {
        if (c == ')' || c == ']') {
            return true;
        } else {
            return false;
        }
    }
}