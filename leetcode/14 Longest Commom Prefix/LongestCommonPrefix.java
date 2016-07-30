/**
 * 14. Longest Common Prefix  QuestionEditorial Solution  My Submissions
 * Difficulty: Easy
 * Write a function to find the longest common prefix string amongst an array of strings.
*/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
         if (strs == null || strs.length == 0) {
             // exception case.
             return "";
         } else if (strs.length == 1) {
             // there is one string.
             return strs[0];
         }
         
         String shortStr = strs[0];
         int indexShortStr = 0;
         for (int i = 1; i < strs.length; i++) {
             if (shortStr.length() > strs[i].length()) {
                 shortStr = strs[i];
                 indexShortStr = i;
             }
         }
         
         // Longest Common Prefix.
         String lcp = "";
         boolean isFirst = true;
         // temporary Longest Common Prefix.
         String tmpLCP = "";
         for (int i = 0; i < strs.length; i++) {
             if (i == indexShortStr) {
                 continue;
             }
             tmpLCP = getLongestCommonPrefix(shortStr, strs[i]);
             if (!isFirst) {
                 if (tmpLCP.length() < lcp.length()) {
                     lcp = tmpLCP;
                 }
             } else {
                 lcp = tmpLCP;
                 isFirst = false;
             }
         }
         
         return lcp;
     }
     
     /**
      * get Longest Commom Prefix between two string.
      * @param shortStr
      * @param str
      */ 
     private String getLongestCommonPrefix(String shortStr, String str) {
         if (shortStr.length() > str.length()) {
             // exception. shorStr should not be longer than str.
             return "";
         }
         
         int i = 0;
         
         while (i < shortStr.length() && shortStr.charAt(i) == str.charAt(i)) {
             i++;
         }
         
         if (i == 0) {
             return "";
         } else {
             return shortStr.substring(0, i);
         }
     }
}