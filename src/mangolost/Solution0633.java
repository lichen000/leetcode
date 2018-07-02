package mangolost;

//Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
//
//        Example 1:
//        Input: 5
//        Output: True
//        Explanation: 1 * 1 + 2 * 2 = 5
//        Example 2:
//        Input: 3
//        Output: False

/**
 *
 */
public class Solution0633 {

    /**
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        if (c < 3) {
            return true;
        }
        int mid = (int) Math.sqrt(c);
        int left = 0, right = mid;
        while (left <= right) {
            int temp = left * left + right * right;
            if (c == temp) {
                return true;
            } else if (c > temp) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution0633 solution = new Solution0633();
        for (int i = 0; i <= 100; i++) {
            if (solution.judgeSquareSum(i)) {
                System.out.println(i);
            }
        }
    }
}