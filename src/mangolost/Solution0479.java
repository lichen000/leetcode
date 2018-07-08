package mangolost;

//Find the largest palindrome made from the product of two n-digit numbers.
//
//        Since the result could be very large, you should return the largest palindrome mod 1337.
//
//        Example:
//
//        Input: 2
//
//        Output: 987
//
//        Explanation: 99 x 91 = 9009, 9009 % 1337 = 987
//
//        Note:
//
//        The range of n is [1,8].

/**
 *
 */
public class Solution0479 {

    /**
     * @param n
     * @return
     */
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int maxNumber = (int) Math.pow(10, n) - 1;
        for (int i = maxNumber; i > maxNumber / 10; i--) {
            String str = new StringBuffer().append(i).reverse().toString();
            long num = Long.valueOf(i + str);
            for (long j = maxNumber; j * j >= num; j--) {
                if (num % j == 0) {
                    return (int) (num % 1337);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution0479 solution = new Solution0479();
        for (int i = 1; i <= 8; i++) {
            System.out.println(i + " : " + solution.largestPalindrome(i));
        }
    }
}