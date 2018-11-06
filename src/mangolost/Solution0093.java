package mangolost;

//Given a string containing only digits, restore it by returning all possible valid IP address combinations.
//
//		Example:
//
//		Input: "25525511135"
//		Output: ["255.255.11.135", "255.255.111.35"]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Solution0093 {

	/**
	 * @param s
	 * @return
	 */
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<>();
		genResult(result, s, 0, "");
		return result;
	}

	/**
	 * @param result
	 * @param remainingStr
	 * @param n
	 * @param currentResult
	 */
	private void genResult(List<String> result, String remainingStr, int n, String currentResult) {
		int len = remainingStr.length();
		if (len < 4 - n || len > 3 * (4 - n)) {
			return;
		}
		if (n == 3) {
			if (len > 1 && remainingStr.charAt(0) == '0') {
				return;
			}
			int last = Integer.valueOf(remainingStr);
			if (last >= 0 && last <= 255) {
				currentResult += remainingStr;
				result.add(currentResult);
			}
		}
		for (int i = 1; i < 4 && i < len; i++) {
			String str = remainingStr.substring(0, i);
			if (str.length() > 1 && str.charAt(0) == '0') {
				return;
			}
			int t = Integer.valueOf(str);
			if (t >= 0 && t <= 255) {
				String next = currentResult + str + ".";
				genResult(result, remainingStr.substring(i), n + 1, next);
			}
		}
	}

	public static void main(String[] args) {
		Solution0093 solution = new Solution0093();
		String s = "19930716";
		List<String> list = solution.restoreIpAddresses(s);
		System.out.println(Arrays.toString(list.toArray()));
	}
}
