package mangolost;

//Given two strings s and t, determine if they are isomorphic.
//
//        Two strings are isomorphic if the characters in s can be replaced to get t.
//
//        All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
//
//        Example 1:
//
//        Input: s = "egg", t = "add"
//        Output: true
//        Example 2:
//
//        Input: s = "foo", t = "bar"
//        Output: false
//        Example 3:
//
//        Input: s = "paper", t = "title"
//        Output: true
//        Note:
//        You may assume both s and t have the same length.

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Solution0205 {

	/**
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isIsomorphic(String s, String t) {
		if (s == null || t == null) {
			throw new RuntimeException("input string should not be null");
		}
		if (s.equals(t)) {
			return true;
		} else if (s.length() != t.length()) {
			return false;
		} else if (s.length() == 1) {
			return true;
		} else {
			Map<Character, Character> map = new HashMap<>();
			Map<Character, Character> map2 = new HashMap<>();
			for (int i = 0, len = s.length(); i < len; i++) {
				char schar = s.charAt(i);
				char tchar = t.charAt(i);
				if (map.containsKey(schar)) {
					char value = map.get(schar);
					if (value != tchar) {
						return false;
					}
				} else {
					if (map2.containsKey(tchar)) {
						return false;
					}
					map.put(schar, tchar);
					map2.put(tchar, schar);
				}
			}
			return true;
		}
	}

	public static void main(String[] args) {
		Solution0205 solution = new Solution0205();
		String s = "ab", t = "ca";
		System.out.println(solution.isIsomorphic(s, t));
	}
}
