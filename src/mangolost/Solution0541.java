package mangolost;

//Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
//        Example:
//        Input: s = "abcdefg", k = 2
//        Output: "bacdfeg"
//        Restrictions:
//        The string consists of lower English letters only.
//        Length of the given string and k will in the range [1, 10000]

/**
 *
 */
public class Solution0541 {

    /**
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int i, j;
        while (start <= len) {
            if (len - start <= k) {
                i = len - 1;
                j = len;
            } else {
                i = start + k - 1;
                j = start + k;
            }
            while (i >= start) {
                sb.append(s.charAt(i));
                i--;
            }
            while (j < len && j < start + 2 * k) {
                sb.append(s.charAt(j));
                j++;
            }
            start += 2 * k;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution0541 solution = new Solution0541();
        String s = "abcdefg";
        int k = 2;
        System.out.println((solution.reverseStr(s, k)));
    }
}