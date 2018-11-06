package mangolost;

import java.util.Stack;

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//        An input string is valid if:
//
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//        Note that an empty string is also considered valid.
//
//        Example 1:
//
//        Input: "()"
//        Output: true
//        Example 2:
//
//        Input: "()[]{}"
//        Output: true
//        Example 3:
//
//        Input: "(]"
//        Output: false
//        Example 4:
//
//        Input: "([)]"
//        Output: false
//        Example 5:
//
//        Input: "{[]}"
//        Output: true

/**
 *
 */
public class Solution0020 {

	/**
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {
		if ("".equals(s)) {
			return true;
		}
		int len = s.length();
		if (len % 2 != 0) {
			return false;
		}
		char last = s.charAt(len - 1);
		if (last == '(' || last == '{' || last == '[') {
			return false;
		}
		Stack<Character> stack = new Stack<>();
		char temp;
		for (int i = 0; i < len; i++) {
			temp = s.charAt(i);
			switch (temp) {
				case '(':
					stack.push(')');
					break;
				case '{':
					stack.push('}');
					break;
				case '[':
					stack.push(']');
					break;
				default:
					if (stack.empty()) {
						return false;
					}
					char x = stack.pop();
					if (temp != x) {
						return false;
					}
			}
		}
		return stack.empty();
	}

	public static void main(String[] args) {
		Solution0020 solution = new Solution0020();
		String s = "({[]})";
		boolean x = solution.isValid(s);
		System.out.println(x);
	}
}
