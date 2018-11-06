package mangolost;

//Write a function that takes a string as input and returns the string reversed.
//
//        Example:
//        Given s = "hello", return "olleh".

/**
 *
 */
public class Solution0344 {

	/**
	 * @param s
	 * @return
	 */
	public String reverseString(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}
		char[] chars = s.toCharArray();
		StringBuilder result = new StringBuilder();
		for (int i = chars.length - 1; i >= 0; i--) {
			result.append(chars[i]);
		}
		return result.toString();
	}

	public static void main(String[] args) {
		Solution0344 solution = new Solution0344();
		System.out.println(solution.reverseString("hello world"));
	}
}