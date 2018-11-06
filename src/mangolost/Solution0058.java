package mangolost;

//Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
//
//		If the last word does not exist, return 0.
//
//		Note: A word is defined as a character sequence consists of non-space characters only.
//
//		Example:
//
//		Input: "Hello World"
//		Output: 5

/**
 *
 */
public class Solution0058 {

	/**
	 * @param s
	 * @return
	 */
	public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int len = s.length();
		int count = 0;
		for (int i = len - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				count++;
			} else if (s.charAt(i) == ' ' && count != 0) {
				return count;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Solution0058 solution = new Solution0058();
		String s = "Hello World";
		System.out.println(solution.lengthOfLastWord(s));
	}
}