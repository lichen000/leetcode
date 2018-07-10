package mangolost;

//A self-dividing number is a number that is divisible by every digit it contains.
//
//        For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
//
//        Also, a self-dividing number is not allowed to contain the digit zero.
//
//        Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
//
//        Example 1:
//        Input:
//        left = 1, right = 22
//        Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
//        Note:
//
//        The boundaries of each input argument are 1 <= left <= right <= 10000.

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Solution0728 {

    /**
     *
     * @param left
     * @param right
     * @return
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean is_self = true;
            int temp = i, digit = 0;
            while (temp != 0) {
                digit = temp % 10;
                if (digit == 0 || i % digit != 0) {
                    is_self = false;
                    break;
                }
                temp = temp / 10;
            }
            if (is_self) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution0728 solution = new Solution0728();
        int left = 1;
        int right = 10000;
        List<Integer> list = solution.selfDividingNumbers(left, right);
        for (int x: list) {
            System.out.println(x);
        }

    }
}