package mangolost;

//Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
//
//        Example 1:
//
//        Input: A = "ab", B = "ba"
//        Output: true
//        Example 2:
//
//        Input: A = "ab", B = "ab"
//        Output: false
//        Example 3:
//
//        Input: A = "aa", B = "aa"
//        Output: true
//        Example 4:
//
//        Input: A = "aaaaaaabc", B = "aaaaaaacb"
//        Output: true
//        Example 5:
//
//        Input: A = "", B = "aa"
//        Output: false
//
//        Note:
//
//        0 <= A.length <= 20000
//        0 <= B.length <= 20000
//        A and B consist only of lowercase letters.

/**
 *
 */
public class Solution0859 {

    /**
     *
     * @param A
     * @param B
     * @return
     */
    public boolean buddyStrings(String A, String B) {
        int len_A = A.length(), len_B = B.length();
        if (len_A < 2 || len_B < 2 || len_A != len_B) {
            return false;
        }
        if (A.equals(B)) {
            int[] counts = new int[26];
            for (int i = 0; i < len_A; i++) {
                counts[A.charAt(i) - 'a']++;
            }
            for (int count: counts) {
                if (count > 1) {
                    return true;
                }
            }
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < len_A; i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    } else if (second == -1) {
                        second = i;
                    } else {
                        return false;
                    }
                }
            }
            return second != -1 && A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first);
        }
    }

    public static void main(String[] args) {
        Solution0859 solution = new Solution0859();
        System.out.println(solution.buddyStrings("reainll", "mangolost"));
    }
}