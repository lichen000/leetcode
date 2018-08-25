package mangolost;

//Implement strStr().
//
//        Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//        Example 1:
//
//        Input: haystack = "hello", needle = "ll"
//        Output: 2
//        Example 2:
//
//        Input: haystack = "aaaaa", needle = "bba"
//        Output: -1
//        Clarification:
//
//        What should we return when needle is an empty string? This is a great question to ask during an interview.
//
//        For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

/**
 *
 */
public class Solution0028 {

    /**
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        if (haystack.equals(needle)) {
            return 0;
        }
        int len1 = haystack.length(), len2 = needle.length();
        if (len1 <= len2) {
            return -1;
        }
        char firstCharInNeedle = needle.charAt(0);
        int index = haystack.indexOf(firstCharInNeedle);
        if (index == -1 || len1 - index < len2) {
            return -1;
        }
        int start = index;
        while (true) {
            int index1 = start, index2 = 0;
            while ((index1 < len1) && (index2 < len2)) {
                if (haystack.charAt(index1) == needle.charAt(index2)) {
                    index1++;
                    index2++;
                } else {
                    break;
                }
            }
            if (index2 == len2) {
                return start;
            } else {
                start++;
                if (len1 - start < len2) {
                    return -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution0028 solution = new Solution0028();
        String haystack = "mississippi", needle = "issip";
        int x = solution.strStr(haystack, needle);
        System.out.println(x);
    }
}
