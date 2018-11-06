package mangolost;

//Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
//
//        Examples:
//        Input: S = "a1b2"
//        Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
//
//        Input: S = "3z4"
//        Output: ["3z4", "3Z4"]
//
//        Input: S = "12345"
//        Output: ["12345"]
//        Note:
//
//        S will be a string with length at most 12.
//        S will consist only of letters or digits.

import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class Solution0784 {

	/**
	 * @param S
	 * @return
	 */
	public List<String> letterCasePermutation(String S) {
		LinkedList<String> result = new LinkedList<>();
		result.add(S);
		int len = S.length();
		for (int i = 0; i < len; i++) {
			char ch = S.charAt(i);
			if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
				int size = result.size();
				for (int j = 0; j < size; j++) {
					String str = result.poll();
					if (str != null) {
						result.add(str.substring(0, i) + Character.toUpperCase(ch) + str.substring(i + 1));
						result.add(str.substring(0, i) + Character.toLowerCase(ch) + str.substring(i + 1));
					}
				}
			}
		}
		return result;
	}


	public static void main(String[] args) {
		Solution0784 solution = new Solution0784();
		String s1 = "a1b2", s2 = "3z4", s3 = "12345";
		List<String> list1 = solution.letterCasePermutation(s1);
		list1.forEach(System.out::println);

		List<String> list2 = solution.letterCasePermutation(s2);
		list2.forEach(System.out::println);

		List<String> list3 = solution.letterCasePermutation(s3);
		list3.forEach(System.out::println);

	}
}