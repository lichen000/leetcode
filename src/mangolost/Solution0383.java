package mangolost;

//Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
//
//        Each letter in the magazine string can only be used once in your ransom note.
//
//        Note:
//        You may assume that both strings contain only lowercase letters.
//
//        canConstruct("a", "b") -> false
//        canConstruct("aa", "ab") -> false
//        canConstruct("aa", "aab") -> true

/**
 *
 */
public class Solution0383 {

	/**
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] times = new int[26];
		for (char ch : magazine.toCharArray()) {
			times[ch - 'a']++;
		}
		for (char ch : ransomNote.toCharArray()) {
			if (times[ch - 'a'] > 0) {
				times[ch - 'a']--;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution0383 solution = new Solution0383();
		System.out.println(solution.canConstruct("a", "b"));
		System.out.println(solution.canConstruct("aa", "ab"));
		System.out.println(solution.canConstruct("aa", "aab"));
	}
}