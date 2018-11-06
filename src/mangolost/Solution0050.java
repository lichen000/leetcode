package mangolost;

//Implement pow(x, n), which calculates x raised to the power n (xn).
//
//        Example 1:
//
//        Input: 2.00000, 10
//        Output: 1024.00000
//        Example 2:
//
//        Input: 2.10000, 3
//        Output: 9.26100
//        Example 3:
//
//        Input: 2.00000, -2
//        Output: 0.25000
//        Explanation: 2-2 = 1/22 = 1/4 = 0.25
//        Note:
//
//        -100.0 < x < 100.0
//        n is a 32-bit signed integer, within the range [−231, 231 − 1]

/**
 *
 */
public class Solution0050 {

	/**
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow(double x, int n) {
		if (x == 0) {
			if (n <= 0) {
				throw new RuntimeException("param error");
			}
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			if (n == -2147483648) {
				return 1 / myPow(x, 2147483647) / x;
			}
			return 1 / myPow(x, -n);
		}
		double result = 1;
		for (int i = n; i > 0; i--) {
			if (i % 2 == 0) {
				x = x * x;
				i = i / 2;
			}
			result = result * x;
		}
		return result;
	}

	public static void main(String[] args) {
		Solution0050 solution = new Solution0050();
		double x = 1.9930716;
		for (int n = -10; n <= 10; n++) {
			double result = solution.myPow(x, n);
			System.out.println("pow(" + x + ", " + n + ") = " + result);
		}

	}
}
