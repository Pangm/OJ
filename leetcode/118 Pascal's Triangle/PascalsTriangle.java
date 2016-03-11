// 118. Pascal's Triangle
// Difficulty: Easy
// Given numRows, generate the first numRows of Pascal's triangle.

// For example, given numRows = 5,
// Return

// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new LinkedList<List<Integer>>();
        List<Integer> lastRow = null;
        
        for (int row = 0; row < numRows; row++) {
            List<Integer> curRow = new ArrayList<Integer>();
            
            // first element : 1
            curRow.add(1);
            
            // add row to rows
            rows.add(curRow);
            
            int length = row + 1;
            int mid = (length + 1) / 2;
            // 前半段
            for (int col = 1; col < mid; col++) {
                curRow.add(lastRow.get(col-1) + lastRow.get(col));
            }
            
            // 后半段对称
            for (int col = mid; col < length; col++) {
                curRow.add(curRow.get(length - 1 - col));
            }
            
            lastRow = curRow;
        }
        
        return rows;
    }
}