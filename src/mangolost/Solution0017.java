package mangolost;

//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
//
//		A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//
//
//
//		Example:
//
//		Input: "23"
//		Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//		Note:
//
//		Although the above answer is in lexicographical order, your answer could be in any order you want.

import java.util.*;

/**
 *
 */
public class Solution0017 {

	private static final Map<String, String> PHONE_MAP = new HashMap<>();

	static {
		PHONE_MAP.put("2", "abc");
		PHONE_MAP.put("3", "def");
		PHONE_MAP.put("4", "ghi");
		PHONE_MAP.put("5", "jkl");
		PHONE_MAP.put("6", "mno");
		PHONE_MAP.put("7", "pqrs");
		PHONE_MAP.put("8", "tuv");
		PHONE_MAP.put("9", "wxyz");
	}

	/**
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits.length() != 0) {
			backtrack(result, "", digits);
		}
		return result;
	}

	/**
	 * @param result
	 * @param combination
	 * @param subDigits
	 */
	private void backtrack(List<String> result, String combination, String subDigits) {
		if (subDigits.length() == 0) {
			result.add(combination);
		} else {
			String digit = subDigits.substring(0, 1);
			String letters = PHONE_MAP.get(digit);
			for (int i = 0, len = letters.length(); i < len; i++) {
				String letter = PHONE_MAP.get(digit).substring(i, i + 1);
				backtrack(result, combination + letter, subDigits.substring(1));
			}
		}
	}

	public static void main(String[] args) {
		Solution0017 solution = new Solution0017();
		String digits = "23";
		List<String> list = solution.letterCombinations(digits);
		System.out.println(Arrays.toString(list.toArray()));
	}
}
