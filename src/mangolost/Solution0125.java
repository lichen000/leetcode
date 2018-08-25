package mangolost;

//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//		Note: For the purpose of this problem, we define empty string as valid palindrome.
//
//		Example 1:
//
//		Input: "A man, a plan, a canal: Panama"
//		Output: true
//		Example 2:
//
//		Input: "race a car"
//		Output: false

/**
 *
 */
public class Solution0125 {

    /**
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        int len = s.length();
        int start = 0, end = len - 1;
        while (true) {
            char ch_start = s.charAt(start);
            while (start < end) {
                ch_start = s.charAt(start);
                if (ch_start >= 'A' && ch_start <= 'Z') {
                    ch_start += 32;
                    break;
                } else if (ch_start >= 'a' && ch_start <= 'z') {
                    break;
                } else if (ch_start >= '0' && ch_start <= '9') {
                    break;
                } else {
                    start++;
                }
            }
            if (start >= end) {
                return true;
            }
            char ch_end = s.charAt(end);
            while (end > start) {
                ch_end = s.charAt(end);
                if (ch_end >= 'A' && ch_end <= 'Z') {
                    ch_end += 32;
                    break;
                } else if (ch_end >= 'a' && ch_end <= 'z') {
                    break;
                } else if (ch_end >= '0' && ch_end <= '9') {
                    break;
                } else {
                    end--;
                }
            }
            if (start >= end) {
                return true;
            }
            if (ch_start != ch_end) {
                return false;
            } else {
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        Solution0125 solution = new Solution0125();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(solution.isPalindrome(s));
    }
}
