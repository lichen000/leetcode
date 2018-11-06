package mangolost;

//Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
//
//		'.' Matches any single character.
//		'*' Matches zero or more of the preceding element.
//		The matching should cover the entire input string (not partial).
//
//		Note:
//
//		s could be empty and contains only lowercase letters a-z.
//		p could be empty and contains only lowercase letters a-z, and characters like . or *.
//		Example 1:
//
//		Input:
//		s = "aa"
//		p = "a"
//		Output: false
//		Explanation: "a" does not match the entire string "aa".
//		Example 2:
//
//		Input:
//		s = "aa"
//		p = "a*"
//		Output: true
//		Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
//		Example 3:
//
//		Input:
//		s = "ab"
//		p = ".*"
//		Output: true
//		Explanation: ".*" means "zero or more (*) of any character (.)".
//		Example 4:
//
//		Input:
//		s = "aab"
//		p = "c*a*b"
//		Output: true
//		Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
//		Example 5:
//
//		Input:
//		s = "mississippi"
//		p = "mis*is*p*."
//		Output: false

/**
 *
 */
public class Solution0010 {

	/**
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
		int len_s = s.length(), len_p = p.length();
		boolean[][] dp = new boolean[len_s + 1][len_p + 1];
		dp[len_s][len_p] = true;
		for (int i = len_s; i >= 0; i--) {
			for (int j = len_p - 1; j >= 0; j--) {
				boolean first_match = i < len_s && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');
				if (j + 1 < len_p && p.charAt(j + 1) == '*') {
					dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
				} else {
					dp[i][j] = first_match && dp[i + 1][j + 1];
				}
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		Solution0010 solution = new Solution0010();
		System.out.println(solution.isMatch("aa", "a"));
		System.out.println(solution.isMatch("aa", "a*"));
		System.out.println(solution.isMatch("ab", ".*"));
		System.out.println(solution.isMatch("aab", "c*a*b"));
		System.out.println(solution.isMatch("mississippi", "mis*is*p*."));
	}
}
