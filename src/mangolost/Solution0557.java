package mangolost;

//Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
//
//        Example 1:
//        Input: "Let's take LeetCode contest"
//        Output: "s'teL ekat edoCteeL tsetnoc"
//        Note: In the string, each word is separated by single space and there will not be any extra space in the string.

/**
 *
 */
public class Solution0557 {

	/**
	 * @param s
	 * @return
	 */
	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		String[] words = s.split(" ");
		for (int i = 0, len = words.length; i < len; i++) {
			String word = words[i];
			String reversedWord = reverse(word);
			sb.append(reversedWord);
			if (i < len - 1) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	/**
	 * @param s
	 * @return
	 */
	private String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		int len = s.length();
		for (int i = len - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution0557 solution = new Solution0557();
		String s = "Let's take LeetCode contest";
		System.out.println((solution.reverseWords(s)));
	}
}