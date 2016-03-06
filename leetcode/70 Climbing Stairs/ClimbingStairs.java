// 70. Climbing Stairs
// Difficulty: Easy
// You are climbing a stair case. It takes n steps to reach to the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

public class Solution {
    public int climbStairs(int n) {
        // Sulotion A:
        // if (n < 0) {
        //     return 0;
        // } else if (n == 0) {
        //     return 1;
        // }else if (n == 1) {
        //     return 1;
        // } else {
        //     return climbStairs(n - 1) + climbStairs(n - 2);
        // }
        
        // Sulotion B:
        int last = 0;
        int cur = 1;
        int tmp = 0;
        
        if (n == 0) {
            return 0;
        }
        
        for (int i = 0; i < n; i++) {
            tmp = cur;
            cur += last;
            last = tmp;
        }
        
        return cur;
        
    }
}