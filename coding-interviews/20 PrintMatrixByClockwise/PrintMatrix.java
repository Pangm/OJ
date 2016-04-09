// 顺时针打印矩阵
// 题目描述

// 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
         
        if (matrix.length == 0 || matrix[0].length == 0) {
            return numbers;
        }
         
        int row_start = 0;
        int col_start = 0;
        int row_end = matrix.length - 1;
        int col_end = matrix[0].length - 1;
        int mid = (Math.min(matrix.length, matrix[0].length) + 1) >> 1;
         
        while (row_start < mid) {
            /**
            * Warning: there may be 1 number, 1 row or 1 column.
            */
 
            // first row: left -> right
            for (int i = col_start; i <= col_end; ++i) {
                numbers.add(matrix[row_start][i]);
            }
             
            row_start++;
 
            // last column: top -> bottom
            for (int j = row_start; j <= row_end; ++j) {
                numbers.add(matrix[j][col_end]);
            }
             
            col_end--;
 
            // last row: left <- right
            for (int i = col_end; i >= col_start && row_start - 1 != row_end; --i) {
                numbers.add(matrix[row_end][i]);
            }
             
            row_end--;
 
            // first column: top <- bottom
            for (int j = row_end; j >= row_start && col_end + 1 != col_start; --j) {
                numbers.add(matrix[j][col_start]);
            }
             
            col_start++;
        }
         
        return numbers;
    }
}
添加笔记
