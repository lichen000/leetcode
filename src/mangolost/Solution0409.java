package mangolost;

//Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
//
//        This is case sensitive, for example "Aa" is not considered a palindrome here.
//
//        Note:
//        Assume the length of given string will not exceed 1,010.
//
//        Example:
//
//        Input:
//        "abccccdd"
//
//        Output:
//        7
//
//        Explanation:
//        One longest palindrome that can be built is "dccaccd", whose length is 7.

/**
 *
 */
public class Solution0409 {

    /**
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        boolean[] arr = new boolean[256];
        int result = 0;
        for (char c : s.toCharArray()) {
            arr[c] = !arr[c];
            if (!arr[c]) {
                result += 2;
            }
        }
        if (result < len) {
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution0409 solution = new Solution0409();
        String s = "abccccdd";
        System.out.println(solution.longestPalindrome(s));
    }
}
