package mangolost;

//Write a function that takes a string as input and reverse only the vowels of a string.
//
//        Example 1:
//        Given s = "hello", return "holle".
//
//        Example 2:
//        Given s = "leetcode", return "leotcede".
//
//        Note:
//        The vowels does not include the letter "y".

/**
 *
 */
public class Solution0345 {

	/**
	 * @param s
	 * @return
	 */
	public String reverseVowels(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}
		StringBuilder result = new StringBuilder();
		char[] chars = s.toCharArray();
		int len = chars.length;
		int left = 0, right = len - 1;
		while (left < right) {
			while (left < len && !isVowel(chars[left])) {
				left++;
			}
			while (right >= 0 && !isVowel(chars[right])) {
				right--;
			}
			if (left < right) {
				if (chars[left] != chars[right]) {
					char temp = chars[left];
					chars[left] = chars[right];
					chars[right] = temp;
				}
				left++;
				right--;
			}
		}
		for (char ch : chars) {
			result.append(ch);
		}
		return result.toString();
	}

	/**
	 * @param ch
	 * @return
	 */
	private boolean isVowel(char ch) {
		switch (ch) {
			case 'A':
				return true;
			case 'E':
				return true;
			case 'I':
				return true;
			case 'O':
				return true;
			case 'U':
				return true;
			case 'a':
				return true;
			case 'e':
				return true;
			case 'i':
				return true;
			case 'o':
				return true;
			case 'u':
				return true;
			default:
				return false;
		}
	}

	public static void main(String[] args) {
		Solution0345 solution = new Solution0345();
		System.out.println(solution.reverseVowels("hello"));
		System.out.println(solution.reverseVowels("leetcode"));
		System.out.println(solution.reverseVowels("hello world"));
		System.out.println(solution.reverseVowels(".,"));
	}
}