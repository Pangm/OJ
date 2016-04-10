// 替换空格
// 题目描述

// 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

public class Solution {
    public String replaceSpace(StringBuffer str) {
        int cnt = 0;
        int len = str.length();
         
        for (int i = 0; i < len; ++i) {
            if (str.charAt(i) == ' ') {
                ++cnt;
            }
        }
                        
        str.setLength(cnt * 2 + len);
        int pos = cnt * 2 + len - 1;
         
        for (int i = len - 1; i >= 0 && cnt > 0; --i) {
            if (str.charAt(i) == ' ') {
                str.setCharAt(pos--, '0');
                str.setCharAt(pos--, '2');
                str.setCharAt(pos--, '%');
                --cnt;
            } else {
                str.setCharAt(pos--, str.charAt(i));
            }
        }
         
        return str.toString();     
    }
}
添加笔记
