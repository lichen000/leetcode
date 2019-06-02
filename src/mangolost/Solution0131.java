package mangolost;

//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//		Return all possible palindrome partitioning of s.
//
//		Example:
//
//		Input: "aab"
//		Output:
//		[
//		["aa","b"],
//		["a","a","b"]
//		]

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class Solution0131 {

    /**
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        partition_iter(res, new LinkedList<>(), s, 0);
        return res;
    }

    /**
     * @param res
     * @param temp
     * @param s
     * @param start
     */
    private void partition_iter(List<List<String>> res, List<String> temp, String s, int start) {
        int len = s.length();
        if (start == len) {
            res.add(new LinkedList<>(temp));
        }
        for (int i = start; i < len; i++) {
            if (isPalindrome(s, start, i)) {
                temp.add(s.substring(start, i + 1));
                partition_iter(res, temp, s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    /**
     * @param s
     * @param start
     * @param end
     * @return
     */
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution0131 solution = new Solution0131();
        String s1 = "aab";
        List<List<String>> list = solution.partition(s1);
        System.out.println("[");
        for (List<String> row : list) {
            System.out.println(Arrays.toString(row.toArray()));
        }
        System.out.println("]");
    }
}
