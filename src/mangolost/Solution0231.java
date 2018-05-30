package mangolost;

//Given an integer, write a function to determine if it is a power of two.
//
//        Example 1:
//
//        Input: 1
//        Output: true
//        Example 2:
//
//        Input: 16
//        Output: true
//        Example 3:
//
//        Input: 218
//        Output: false

/**
 *
 */
public class Solution0231 {

    /**
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1 || n == 2) {
            return true;
        }
        while (n % 2 == 0) {
            n = n / 2;
            if (n == 2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution0231 solution = new Solution0231();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (solution.isPowerOfTwo(i)) {
                System.out.println(i);
            }
        }
        System.out.println(solution.isPowerOfTwo(Integer.MAX_VALUE));
    }
}
