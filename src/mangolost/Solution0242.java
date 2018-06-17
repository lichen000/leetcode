package mangolost;

//Given two strings s and t , write a function to determine if t is an anagram of s.
//
//        Example 1:
//
//        Input: s = "anagram", t = "nagaram"
//        Output: true
//        Example 2:
//
//        Input: s = "rat", t = "car"
//        Output: false
//        Note:
//        You may assume the string contains only lowercase alphabets.
//
//        Follow up:
//        What if the inputs contain unicode characters? How would you adapt your solution to such case?

/**
 *
 */
public class Solution0242 {

    /**
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int len_s = s.length(), len_t = t.length();
        if (len_s != len_t) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < len_s; i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < len_t; i++) {
            int index = t.charAt(i) - 'a';
            if (table[index] == 0) {
                return false;
            }
            table[index]--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution0242 solution = new Solution0242();
        String s = "anagram", t = "nagaram";
        System.out.println(solution.isAnagram(s, t));

        String s2 = "rat", t2 = "car";
        System.out.println(solution.isAnagram(s2, t2));
    }
}
