package mangolost;

//Given a word, you need to judge whether the usage of capitals in it is right or not.
//
//        We define the usage of capitals in a word to be right when one of the following cases holds:
//
//        All letters in this word are capitals, like "USA".
//        All letters in this word are not capitals, like "leetcode".
//        Only the first letter in this word is capital if it has more than one letter, like "Google".
//        Otherwise, we define that this word doesn't use capitals in a right way.
//        Example 1:
//        Input: "USA"
//        Output: True
//        Example 2:
//        Input: "FlaG"
//        Output: False
//        Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.

/**
 *
 */
public class Solution0520 {

	/**
	 * @param word
	 * @return
	 */
	public boolean detectCapitalUse(String word) {
		int len = word.length();
		if (len == 1) {
			return true;
		}
		char first = word.charAt(0);
		char second = word.charAt(1);
		if (first < 'a') {
			if (second < 'a') {
				for (int i = 2; i < len; i++) {
					if (word.charAt(i) > 'Z') {
						return false;
					}
				}
			} else {
				for (int i = 2; i < len; i++) {
					if (word.charAt(i) < 'a') {
						return false;
					}
				}
			}
		} else {
			for (int i = 1; i < len; i++) {
				if (word.charAt(i) < 'a') {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution0520 solution = new Solution0520();
		System.out.println((solution.detectCapitalUse("USA")));
		System.out.println((solution.detectCapitalUse("FlaG")));
	}
}