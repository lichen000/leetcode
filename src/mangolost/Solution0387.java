package mangolost;

//Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
//
//        Examples:
//
//        s = "leetcode"
//        return 0.
//
//        s = "loveleetcode",
//        return 2.

import java.util.Arrays;

/**
 *
 */
public class Solution0387 {

	/**
	 * @param s
	 * @return
	 */
	public int firstUniqChar(String s) {
		int len = s.length();
		if (len == 1) {
			return 0;
		}
		int[] nums = new int[256];
		int index = -1;
		Arrays.fill(nums, 0);
		for (int i = 0; i < len; i++) {
			nums[s.charAt(i)]++;
		}
		for (int i = 0; i < len; i++) {
			if (nums[s.charAt(i)] == 1) {
				index = i;
				break;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		Solution0387 solution = new Solution0387();
		String s = "Happy birthday, lichen";
		System.out.println(solution.firstUniqChar(s));
	}
}