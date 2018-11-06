package mangolost;

//You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
//
//        The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
//
//        Example 1:
//
//        Input: J = "aA", S = "aAAbbbb"
//        Output: 3
//        Example 2:
//
//        Input: J = "z", S = "ZZ"
//        Output: 0
//        Note:
//
//        S and J will consist of letters and have length at most 50.
//        The characters in J are distinct.

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class Solution0771 {

	/**
	 * @param J
	 * @param S
	 * @return
	 */
	public int numJewelsInStones(String J, String S) {
		int len_j = J.length();
		int len_s = S.length();
		if (len_j == 0 || len_s == 0) {
			return 0;
		}
		int result = 0;
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < len_j; i++) {
			set.add(J.charAt(i));
		}
		for (int i = 0; i < len_s; i++) {
			if (set.contains(S.charAt(i))) {
				result++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution0771 solution = new Solution0771();
		String J = "aA", S = "aAAbbbb";
		System.out.println(solution.numJewelsInStones(J, S));

		String J2 = "z", S2 = "ZZ";
		System.out.println(solution.numJewelsInStones(J2, S2));


	}
}