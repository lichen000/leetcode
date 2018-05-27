package mangolost;

//Given a 32-bit signed integer, reverse digits of an integer.
//
//        Example 1:
//
//        Input: 123
//        Output: 321
//        Example 2:
//
//        Input: -123
//        Output: -321
//        Example 3:
//
//        Input: 120
//        Output: 21
//        Note:
//        Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

/**
 *
 */
public class Solution0007 {

    /**
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        } else if (x < 0) {
            return -reverse(-x);
        } else if (x < 10) {
            return x;
        } else {
            int[] numbers = new int[10];
            numbers[0] = x % 10;
            int restInt = x / 10;
            double reversedValue = numbers[0];
            for (int i = 1; i < 10; i++) {
                numbers[i] = restInt % 10;
                restInt = restInt / 10;
                reversedValue = reversedValue * 10 + numbers[i];
                if (restInt == 0) {
                    break;
                }
            }
            if (reversedValue > Integer.MAX_VALUE) {
                return 0;
            }
            return (int) reversedValue;
        }
    }

    public static void main(String[] args) {
        Solution0007 solution = new Solution0007();
        int x = 19930716;
        int y = solution.reverse(x);
        System.out.println(y);
    }
}
