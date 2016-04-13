// 字符串的排列

// 题目描述

// 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 结果请按字母顺序输出。 
// 输入描述:
// 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。

import java.util.ArrayList;
public class Solution {
    public ArrayList<String> Permutation(String str) {
       	ArrayList<String> strs = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            // do nothing.
        } else {
            Process(new StringBuffer(str), 0, new StringBuffer(str), strs);
        }
        
        return strs;
        
    }
    
    public void Process(StringBuffer sbC, int pos, StringBuffer sb, ArrayList<String> strs) {
        if (sbC.length() == 0) {
            // sbC is empty.
            strs.add(new String(sb));
        }
        char cPrev = ' ';
        for (int i = 0; i < sbC.length(); ++i) {
            if (i == 0) {
                cPrev = sbC.charAt(i);
            } else {
                // avoid redundant string.
                if (cPrev == sbC.charAt(i)) {
                    continue;
                } else {
                    cPrev = sbC.charAt(i);
                }
            }
            
            sb.setCharAt(pos, sbC.charAt(i));
            Process(sbC.deleteCharAt(i), pos + 1, sb, strs);
            sbC.insert(i, sb.charAt(pos));
        }
    }
}