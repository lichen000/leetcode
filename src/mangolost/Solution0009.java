package mangolost;

//Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
//
//        Example 1:
//
//        Input: 121
//        Output: true
//        Example 2:
//
//        Input: -121
//        Output: false
//        Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
//        Example 3:
//
//        Input: 10
//        Output: false
//        Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Solution0009 {

    /**
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        } else {
            List<Integer> numbers = new ArrayList<>();
            int restInt = x;
            for (int i = 0; i < 10; i++) {
                numbers.add(restInt % 10);
                restInt = restInt / 10;
                if (restInt == 0) {
                    break;
                }
            }
            int len = numbers.size();
            for (int i = 0; i < (len + 1) / 2; i++) {
                int j = len - 1 - i;
                if (!numbers.get(i).equals(numbers.get(j))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution0009 solution = new Solution0009();
        int x = 121;
        boolean y = solution.isPalindrome(x);
        System.out.println(y);
    }
}
