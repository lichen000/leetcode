package mangolost;

//Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
//
//		The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
//
//		You may assume the integer does not contain any leading zero, except the checkNumber 0 itself.
//
//		Example 1:
//
//		Input: [1,2,3]
//		Output: [1,2,4]
//		Explanation: The array represents the integer 123.
//		Example 2:
//
//		Input: [4,3,2,1]
//		Output: [4,3,2,2]
//		Explanation: The array represents the integer 4321.

/**
 *
 */
public class Solution0066 {

	/**
	 * @param digits
	 * @return
	 */
	public int[] plusOne(int[] digits) {
		int len = digits.length;
		int sum = 0;
		for (int i = len - 1; i >= 0; i--) {
			sum = digits[i] + 1;
			if (sum == 10) {
				digits[i] = 0;
			} else {
				digits[i] = sum;
				break;
			}
		}
		if (sum == 10) {
			int[] result = new int[len + 1];
			System.arraycopy(digits, 0, result, 1, len);
			result[0] = 1;
			return result;
		} else {
			return digits;
		}
	}

	public static void main(String[] args) {
		Solution0066 solution = new Solution0066();
		int[] digits = new int[]{4, 3, 2, 1};
		int[] y = solution.plusOne(digits);
		System.out.print("[" + y[0]);
		for (int i = 1; i < y.length; i++) {
			System.out.print(" , ");
			System.out.print(y[i]);
		}
		System.out.println("]");
	}
}
