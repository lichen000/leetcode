package mangolost;

//Given a string, find the length of the longest substring without repeating characters.
//
//		Examples:
//
//		Given "abcabcbb", the answer is "abc", which the length is 3.
//
//		Given "bbbbb", the answer is "b", with the length of 1.
//
//		Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class Solution0003 {

	/**
	 *
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		int len = s.length();
		if (len < 2) {
			return len;
		}
		int result = 0, left = 0, right = 0;
		Set<Character> set = new HashSet<>();
		while (right < len) {
			char ch = s.charAt(right);
			if (set.contains(ch)) {
				set.remove(s.charAt(left));
				left++;
			} else {
				set.add(ch);
				right++;
				int size = set.size();
				if (size > result) {
					result = size;
				}
			}
		}
		return result;
	}

    public static void main(String[] args) {
        Solution0003 solution = new Solution0003();
        String s = "mangolost";
        int n = solution.lengthOfLongestSubstring(s);
        System.out.println(n);
    }
}
