package mangolost;

//Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
//        Example 1:
//
//        Input: "babad"
//        Output: "bab"
//        Note: "aba" is also a valid answer.
//        Example 2:
//
//        Input: "cbbd"
//        Output: "bb"

/**
 *
 */
public class Solution0005 {

	/**
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		int len = s.length();
		if (len == 0) {
			return "";
		}
		if (len == 1) {
			return s;
		}
		int start = 0, end = 0;
		for (int i = 0; i < len; i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int maxLen = Math.max(len1, len2);
			if (maxLen > end - start) {
				start = i - (maxLen - 1) / 2;
				end = i + maxLen / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	/**
	 * @param s
	 * @param left
	 * @param right
	 * @return
	 */
	private int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right, len = s.length();
		while (L >= 0 && R < len && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}

	public static void main(String[] args) {
		Solution0005 solution = new Solution0005();
		System.out.println(solution.longestPalindrome("babad"));
		System.out.println(solution.longestPalindrome("cbbd"));
		System.out.println(solution.longestPalindrome("reainll"));
	}
}
