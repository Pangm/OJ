// 119. Pascal's Triangle II
// Difficulty: Easy
// Given an index k, return the kth row of the Pascal's triangle.

// For example, given k = 3,
// Return [1,3,3,1].

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        int length = rowIndex + 1;
        
        
        // for (int i = 1; i <= rowIndex + 1; i++) {
        //     njc *= i;
        // }
        
        List<Integer> row = new ArrayList<Integer>();
        int mid = (length + 1) / 2;
        int kjc = 1;
        int njc = 1;
        
        long result = 1;
        
        // 前半部分
        row.add(1);
        for (int i = 1; i < mid; i++) {
            // kjc *= i;
            // njc *= length - i;
            // avoid overflow.
            result = result * (length - i) / i;
            row.add((int) result);
        }
        
        // 对称性，后半部分
        for (int i = mid; i < length; i++) {
            row.add(row.get(length - 1 - i));
        }
        
        return row;
    }
}