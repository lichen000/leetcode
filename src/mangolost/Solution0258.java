package mangolost;

//Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
//
//        Example:
//
//        Input: 38
//        Output: 2
//        Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
//        Since 2 has only one digit, return it.
//        Follow up:
//        Could you do it without any loop/recursion in O(1) runtime?

/**
 *
 */
public class Solution0258 {

    /**
     * @param num
     * @return
     */
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        } else {
            int temp = num % 9;
            if (temp == 0) {
                return 9;
            } else {
                return temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution0258 solution = new Solution0258();
        for (int i = 0; i <= 100; i++) {
            System.out.println(i + " : " + solution.addDigits(i));
        }
    }
}