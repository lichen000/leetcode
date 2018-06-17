package mangolost;

//Given a pattern and a string str, find if str follows the same pattern.
//
//        Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
//
//        Example 1:
//
//        Input: pattern = "abba", str = "dog cat cat dog"
//        Output: true
//        Example 2:
//
//        Input:pattern = "abba", str = "dog cat cat fish"
//        Output: false
//        Example 3:
//
//        Input: pattern = "aaaa", str = "dog cat cat dog"
//        Output: false
//        Example 4:
//
//        Input: pattern = "abba", str = "dog dog dog dog"
//        Output: false
//        Notes:
//        You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Solution0290 {

    /**
     *
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        int len = words.length;
        if (pattern.length() != len) {
            return false;
        }
        Map<Character, String> map = new HashMap<>(26);
        for (int i = 0; i < len; i++) {
            Character c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(words[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(words[i])) {
                    return false;
                }
                map.put(c, words[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution0290 solution = new Solution0290();
        String pattern1 = "abba", str1 = "dog cat cat dog";
        String pattern2 = "abba", str2 = "dog cat cat fish";
        String pattern3 = "aaaa", str3 = "dog cat cat dog";
        String pattern4 = "abba", str4 = "dog dog dog dog";
        System.out.println(solution.wordPattern(pattern1, str1));
        System.out.println(solution.wordPattern(pattern2, str2));
        System.out.println(solution.wordPattern(pattern3, str3));
        System.out.println(solution.wordPattern(pattern4, str4));
    }
}