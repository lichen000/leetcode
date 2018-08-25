package mangolost;

//Given a positive integer num, write a function which returns True if num is a perfect square else False.
//
//        Note: Do not use any built-in library function such as sqrt.
//
//        Example 1:
//
//        Input: 16
//        Returns: True
//        Example 2:
//
//        Input: 14
//        Returns: False

/**
 *
 */
public class Solution0367 {

    /**
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int maxSqrt = 46340;
        int low = 1, high = (num / 2 < maxSqrt) ? (num / 2) : maxSqrt;
        while (low < high) {
            int mid = (low + high) / 2;
            double temp = mid * mid;
            if (temp == num) {
                return true;
            } else if (temp < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low * low == num;
    }

    public static void main(String[] args) {
        Solution0367 solution = new Solution0367();
        for (int i = 1; i <= 10000; i++) {
            if (solution.isPerfectSquare(i)) {
                System.out.println(i + " : " + Math.sqrt(i));
            }
        }
        System.out.println(solution.isPerfectSquare(808201));
        System.out.println(808201 + " : " + Math.sqrt(808201));
    }
}