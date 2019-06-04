package mangolost;

//Given two binary strings, return their sum (also a binary string).
//
//        The input strings are both non-empty and contains only characters 1 or 0.
//
//        Example 1:
//
//        Input: a = "11", b = "1"
//        Output: "100"
//        Example 2:
//
//        Input: a = "1010", b = "1011"
//        Output: "10101"

/**
 *
 */
public class Solution0067 {

	/**
	 * @param a
	 * @param b
	 * @return
	 */
	public String addBinary(String a, String b) {
		if (a.length() < b.length()) {
			String temp = a;
			a = b;
			b = temp;
		}
		int len_a = a.length();
		int len_b = b.length();
		int carry = 0, temp = 0;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < len_a; i++) {
			int p = a.charAt(len_a - 1 - i) - '0';
			int q = (i < len_b) ? b.charAt(len_b - 1 - i) - '0' : 0;
			temp = p + q + carry;
			carry = temp / 2;
			result.insert(0, temp % 2);
		}
		if (carry == 0) {
			return result.toString();
		} else {
			return "1" + result;
		}
	}

	public static void main(String[] args) {
		Solution0067 solution = new Solution0067();
		String a = "1010", b = "1011";
		System.out.println(solution.addBinary(a, b));
	}
}
