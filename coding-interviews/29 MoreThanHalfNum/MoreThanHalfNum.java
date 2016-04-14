// 数组中出现次数超过一半的数字
// 题目描述

// 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
public class Solution {
    // solution A:
    /*public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 0) {
            return 0;
        }
         
        int candicate = array[0];
        int cnt = 0;
         
        for (int i = 1; i < array.length; ++i) {
            if (candicate == array[i]) {
                ++cnt;
            } else {
                if (cnt > 0) {
                    --cnt;
                } else {
                    // in case of cnt = 0
                    candicate = array[i];
                }
            }
        }
         
        if (checkNum(candicate, array)) {
            return candicate;
        } else {
            return 0;
        }
    }*/
     
    // solution B:
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 0) {
            return 0;
        }
         
        int candicate = findNum(0, array.length - 1, array);
         
        if (checkNum(candicate, array)) {
            return candicate;
        } else {
            return 0;
        }
    }
     
    public int findNum(int left, int right, int [] array) {
        int p = partition(left, right, array);
         
        int mid = array.length >> 1;
         
        if (p == mid) {
            return array[p];
        } else if (p > mid) {
            return findNum(left, p - 1, array);
        } else {
            // p < mid
            return findNum(p + 1, right, array);
        }
         
    }
     
    public void swap(int left, int right, int [] array) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
     
    public int partition(int left, int right, int [] array) {
        // left < right
        int x = array[left];
        int l = left;
         
        ++left;
         
        while (left < right) {
            // find min index of element > x in left part.
            /*for(int i = left; i < right; ++i) {
                if (array[i] > x) {
                    left = i;
                    break;
                }
            }*/
            while (left < right && array[left] < x) {
            	++left;
            }
            // find max index of element < x in right part.
            /*for(int i = right; i > left; --i) {
                if (array[i] < x) {
                    right = i;
                    break;
                }
            }*/
            while (left < right && array[right] > x) {
                --right;
            }
            
            // exchange two elements.
            if (left < right) {
            	swap(left, right, array);
                ++left;
                --right;
            }
        }
         
        swap(l, right, array);
         
        return right;
         
    }
     
    public boolean checkNum(int num, int [] array) {
        int cnt = 0;
        for (int i = 0; i < array.length; ++i) {
            if (num == array[i]) {
                ++cnt;
            }
        }
         
        int mid = array.length >> 1;
         
        if (cnt > mid) {
            return true;
        } else {
            return false;
        } 
    }
}