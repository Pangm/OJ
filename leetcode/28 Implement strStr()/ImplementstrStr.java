/*28. Implement strStr()  QuestionEditorial Solution  My Submissions
Difficulty: Easy
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.*/

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null) {
            // exception case.
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        
        int maxIndex = haystack.length() - needle.length() + 1;
        for (int base = 0; base < maxIndex; base++) {
            int j = 0;
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(base+j) != needle.charAt(j)) {
                    break;
                }
            }
            
            if (j == needle.length()) {
                // found
                return base;
            }
        }
        
        return -1;
    }
}