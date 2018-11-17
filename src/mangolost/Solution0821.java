package mangolost;

//Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
//
//        Example 1:
//
//        Input: S = "loveleetcode", C = 'e'
//        Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
//
//
//        Note:
//
//        S string length is in [1, 10000].
//        C is a single character, and guaranteed to be in string S.
//        All letters in S and C are lowercase.

import java.util.Arrays;

/**
 *
 */
public class Solution0821 {

	/**
	 * @param S
	 * @param C
	 * @return
	 */
	public int[] shortestToChar(String S, char C) {
		int len = S.length();
		int[] result = new int[len];
		int forward = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			if (S.charAt(i) == C) {
				forward = i;
			}
			result[i] = i - forward;
		}
		int backward = Integer.MAX_VALUE;
		for (int i = len - 1; i >= 0; i--) {
			if (S.charAt(i) == C) {
				backward = i;
			}
			result[i] = Math.min(result[i], backward - i);
		}
		return result;
	}

	public static void main(String[] args) {
		Solution0821 solution = new Solution0821();
		String S = "lclichen";
		char C = 'l';
		int[] result = solution.shortestToChar(S, C);
		System.out.println(Arrays.toString(result));
	}
}