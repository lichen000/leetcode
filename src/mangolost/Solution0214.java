package mangolost;

//Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
//
//        Example 1:
//
//        Input: "aacecaaa"
//        Output: "aaacecaaa"
//        Example 2:
//
//        Input: "abcd"
//        Output: "dcbabcd"


import java.util.Arrays;

/**
 *
 */
public class Solution0214 {

    /**
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        char[] chars = new char[len * 2 + 1];
        int start = 0, end = len * 2;
        for (char c : s.toCharArray()) {
            chars[start] = c;
            start++;
            chars[end] = c;
            end--;
        }
        chars[len] = '#';
        int[] f = new int[2 * len + 1];
        for (int i = 1; i < 2 * len + 1; i++) {
            int t = f[i - 1];
            while (t > 0 && chars[i] != chars[t]) {
                t = f[t - 1];
            }
            if (chars[i] == chars[t]) {
                t++;
            }
            f[i] = t;
        }
        return new String(Arrays.copyOfRange(chars, len + 1, 2 * len - f[2 * len - 1])) + s;
    }

    public static void main(String[] args) {
        Solution0214 solution = new Solution0214();
        String s = "mangolost";
        System.out.println(solution.shortestPalindrome(s));
    }
}
