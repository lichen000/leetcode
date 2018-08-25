package mangolost;

//The count-and-say sequence is the sequence of integers with the first five terms as following:
//
//        1.     1
//        2.     11
//        3.     21
//        4.     1211
//        5.     111221
//        1 is read off as "one 1" or 11.
//        11 is read off as "two 1s" or 21.
//        21 is read off as "one 2, then one 1" or 1211.
//        Given an integer n, generate the nth term of the count-and-say sequence.
//
//        Note: Each term of the sequence of integers will be represented as a string.
//
//        Example 1:
//
//        Input: 1
//        Output: "1"
//        Example 2:
//
//        Input: 4
//        Output: "1211"

/**
 *
 */
public class Solution0038 {

    /**
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String pre = countAndSay(n - 1);
            int len = pre.length();
            StringBuilder result = new StringBuilder();
            char currentChar = pre.charAt(0);
            int currentTimes = 1;
            String part = String.valueOf(currentTimes) + String.valueOf(currentChar);
            for (int i = 1; i < len; i++) {
                char tempChar = pre.charAt(i);
                if (currentChar == tempChar) {
                    currentTimes++;
                } else {
                    result.append(part);
                    currentChar = tempChar;
                    currentTimes = 1;
                }
                part = String.valueOf(currentTimes) + String.valueOf(currentChar);
            }
            result.append(part);
            return result.toString();
        }
    }

    public static void main(String[] args) {
        Solution0038 solution = new Solution0038();
        for (int i = 1; i < 50; i++) {
            System.out.println(solution.countAndSay(i));
        }
    }
}
