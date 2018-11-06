package mangolost;

//Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
//
//        Example 1:
//
//        Input: "ab-cd"
//        Output: "dc-ba"
//        Example 2:
//
//        Input: "a-bC-dEf-ghIj"
//        Output: "j-Ih-gfE-dCba"
//        Example 3:
//
//        Input: "Test1ng-Leet=code-Q!"
//        Output: "Qedo1ct-eeLg=ntse-T!"
//
//
//        Note:
//
//        S.length <= 100
//        33 <= S[i].ASCIIcode <= 122
//        S doesn't contain \ or "

/**
 *
 */
public class Solution0917 {

	/**
	 * @param S
	 * @return
	 */
	public String reverseOnlyLetters(String S) {
		int len = S.length();
		if (len < 2) {
			return S;
		}
		int left = 0;
		int right = len - 1;
		StringBuilder result = new StringBuilder(S);
		while (left < right) {
			while (left < len && !Character.isAlphabetic(S.charAt(left))) {
				left++;
			}
			while (right >= 0 && !Character.isAlphabetic(S.charAt(right))) {
				right--;
			}
			if (left >= right) {
				break;
			}
			result.replace(left, left + 1, S.charAt(right) + "");
			result.replace(right, right + 1, S.charAt(left) + "");
			left++;
			right--;
		}
		return result.toString();
	}

	public static void main(String[] args) {
		Solution0917 solution = new Solution0917();
		String s = "mango-2018-reainll-2017-lost";
		String s2 = solution.reverseOnlyLetters(s);
		System.out.println(s2);
	}
}