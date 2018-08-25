package mangolost;

//You are climbing a stair case. It takes n steps to reach to the top.
//
//        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//        Note: Given n will be a positive integer.
//
//        Example 1:
//
//        Input: 2
//        Output: 2
//        Explanation: There are two ways to climb to the top.
//        1. 1 step + 1 step
//        2. 2 steps
//        Example 2:
//
//        Input: 3
//        Output: 3
//        Explanation: There are three ways to climb to the top.
//        1. 1 step + 1 step + 1 step
//        2. 1 step + 2 steps
//        3. 2 steps + 1 step

/**
 *
 */
public class Solution0070 {

    /**
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        } else {
            int pre = 1;
            int now = 2;
            int next = 0;
            for (int i = 3; i <= n; i++) {
                next = pre + now;
                pre = now;
                now = next;
            }
            return next;
        }
    }

    public static void main(String[] args) {
        Solution0070 solution = new Solution0070();
        for (int i = 1; i <= 30; i++) {
            System.out.println("climbStaris(" + i + ")=" + solution.climbStairs(i));
        }
    }
}
