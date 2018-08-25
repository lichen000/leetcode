package mangolost;

//Implement int sqrt(int x).
//
//        Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
//
//        Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
//
//        Example 1:
//
//        Input: 4
//        Output: 2
//        Example 2:
//
//        Input: 8
//        Output: 2
//        Explanation: The square root of 8 is 2.82842..., and since
//        the decimal part is truncated, 2 is returned.

/**
 *
 */
public class Solution0069 {

    /**
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        } else if (x <= 3) {
            return 1;
        }
        if (x == Integer.MAX_VALUE) {
            return 46340;
        }
        int low = 1, high = 46340;
        int middle = 0;
        while (low < high) {
            middle = (low + high) / 2;
            int temp = middle * middle;
            if (temp == x) {
                return middle;
            } else if (temp > x) {
                high = middle - 1;
            } else {
                low = middle;
                if (high - low == 1) {
                    if (high * high <= x) {
                        return high;
                    } else {
                        return low;
                    }
                }
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Solution0069 solution = new Solution0069();
        for (int i = 0; i <= 100; i++) {
            System.out.println("sqrt(" + i + ")=" + solution.mySqrt(i));
        }
        System.out.println("sqrt(" + 2147483646 + ")=" + solution.mySqrt(2147483646));
    }
}
