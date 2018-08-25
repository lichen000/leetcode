package mangolost;

//Write a function to find the longest common prefix string amongst an array of strings.
//
//        If there is no common prefix, return an empty string "".
//
//        Example 1:
//
//        Input: ["flower","flow","flight"]
//        Output: "fl"
//        Example 2:
//
//        Input: ["dog","racecar","car"]
//        Output: ""
//        Explanation: There is no common prefix among the input strings.
//        Note:
//
//        All given inputs are in lowercase letters a-z.

/**
 *
 */
public class Solution0014 {

    /**
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        int lenx = strs.length;
        if (lenx == 0) {
            return "";
        } else if (lenx == 1) {
            return strs[0];
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            int len = str.length();
            if (len < minLength) {
                minLength = len;
            }
        }
        String str0 = strs[0];
        int lastIndex = -1;
        for (int i = 0; i < minLength; i++) {
            char x = str0.charAt(i);
            boolean flag = true;
            for (int y = 1; y < lenx; y++) {
                if (strs[y].charAt(i) != x) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                lastIndex = i;
            } else {
                break;
            }
        }
        if (lastIndex == -1) {
            return "";
        }
        return str0.substring(0, lastIndex + 1);
    }

    public static void main(String[] args) {
        Solution0014 solution = new Solution0014();
        String[] x = new String[]{"flower", "flow", "flight"};
        String y = solution.longestCommonPrefix(x);
        System.out.println(y);
    }
}
