package mangolost;

//Given an integer, write a function to determine if it is a power of three.
//
//        Example 1:
//
//        Input: 27
//        Output: true
//        Example 2:
//
//        Input: 0
//        Output: false
//        Example 3:
//
//        Input: 9
//        Output: true
//        Example 4:
//
//        Input: 45
//        Output: false
//        Follow up:
//        Could you do it without using any loop / recursion?

/**
 *
 */
public class Solution0326 {

	/**
	 * @param n
	 * @return
	 */
	public boolean isPowerOfThree(int n) {
		while (n != 0 && n % 3 == 0) {
			n = n / 3;
		}
		return n == 1;
	}

	public static void main(String[] args) {
		Solution0326 solution = new Solution0326();
		for (int i = 1; i <= 10000; i++) {
			if (solution.isPowerOfThree(i)) {
				System.out.println(i + " : " + solution.isPowerOfThree(i));
			}
		}
	}
}