// 最小的K个数
// 题目描述

// 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

import java.util.*;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        
        if (input == null || k <= 0 || k > input.length) {
            return nums;
        } 
        
        GetLeastNumbers(input, k);
        for (int i = 0; i < k; ++ i) {
            nums.add(input[i]);
        }
        
        return nums;
    }
    
    public void GetLeastNumbers(int [] input, int k) {
        int p = Partition(input, 0, input.length - 1);
        
        int left = 0;
        int right = input.length - 1;
        
        while (k - 1 != p) { 
            if (k - 1 < p) {
                right = p - 1;
            } else {
                // p < k
                left = p + 1;                
            }
            p = Partition(input, left, right);
        }
    }
    
    public int Partition(int [] input, int left, int right) {
        int l = left;
        int x = input[left];
        
        ++ left;
        
        while (left < right) {
            // find index of the number smaller than x in left part.
            while (left < right && input[left] < x) {
                ++ left;
            }
            
            // find index of the number biger than x in right part.
            while (left < right && input[right] > x) {
                -- right;
            }
            
            if (left < right) {
                // swap elements.
                Swap(input, left, right);
                ++ left;
                -- right;
            }
        }
        
        // swap first element and the element in right pos.
        Swap(input, l, right);
        
        return right;
    }
    
    public void Swap(int [] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
}