package mangolost;

//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//		For example, given n = 3, a solution set is:
//
//		[
//		"((()))",
//		"(()())",
//		"(())()",
//		"()(())",
//		"()()()"
//		]

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Solution0022 {

	/**
	 *
	 * @param n
	 * @return
	 */
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		if (n == 1) {
			list.add("()");
			return list;
		}
		String initial = "";
		int left = n, right = 0;
		doRecursiveAction(list, initial, left, right);
		return list;
	}

	/**
	 *
	 * @param list
	 * @param str
	 * @param left
	 * @param right
	 */
	public void doRecursiveAction(List<String> list, String str, int left, int right) {
		if (left == 0 && right == 0) {
			list.add(str);
			return;
		}
		if (left > 0) {
			String s = str + "(";
			doRecursiveAction(list, s, left - 1, right + 1);
		}
		if (right > 0) {
			String s = str + ")";
			doRecursiveAction(list, s, left , right - 1);
		}

	}

    public static void main(String[] args) {
        Solution0022 solution = new Solution0022();
		int n = 1;
		List<String> list = solution.generateParenthesis(n);
		for(String x: list) {
			System.out.println(x);
		}

    }
}
