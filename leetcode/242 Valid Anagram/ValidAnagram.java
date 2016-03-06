// 242. Valid Anagram
// Difficulty: Easy
// Given two strings s and t, write a function to determine if t is an anagram of s.

// For example,
// s = "anagram", t = "nagaram", return true.
// s = "rat", t = "car", return false.

// Note:
// You may assume the string contains only lowercase alphabets.

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        } else {
            int[] sCounter = counterStr(s);
            int[] tCounter = counterStr(t);
            return compare(sCounter, tCounter);
        }
    }
    
    private int[] counterStr(String s) {
        int[] counter = new int[27];
        
        for (int i = 0; i < counter.length; i++) {
            counter[i] = 0;
        }
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i)-'a'] += 1;
        }
        
        return counter;
    }
    
    private boolean compare(int[] a, int[] b) {
        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}