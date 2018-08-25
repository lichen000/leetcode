package mangolost;

//Given an integer n, return the number of trailing zeroes in n!.
//
//        Example 1:
//
//        Input: 3
//        Output: 0
//        Explanation: 3! = 6, no trailing zero.
//        Example 2:
//
//        Input: 5
//        Output: 1
//        Explanation: 5! = 120, one trailing zero.
//        Note: Your solution should be in logarithmic time complexity.

/**
 *
 */
public class Solution0172 {

    /**
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        } else if (n == 5) {
            return 1;
        } else {
            int count = 0;
            while (n > 0) {
                int temp = n / 5;
                count = count + temp;
                n = temp;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution0172 solution = new Solution0172();
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " : " + solution.trailingZeroes(i));
        }
    }
}
