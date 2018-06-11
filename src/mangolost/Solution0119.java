package mangolost;

//Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
//
//        Note that the row index starts from 0.
//
//
//        In Pascal's triangle, each number is the sum of the two numbers directly above it.
//
//        Example:
//
//        Input: 3
//        Output: [1,3,3,1]
//        Follow up:
//
//        Could you optimize your algorithm to use only O(k) extra space?

import java.util.*;

/**
 *
 */
public class Solution0119 {

    /**
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex == 0) {
            result.add(1);
            return result;
        }
        int[] nums = new int[rowIndex + 1];
        nums[0] = 1;
        result.add(1);
        int middle = rowIndex / 2;
        for (int i = 1; i <= middle; i++) {
            if (nums[i - 1] % i == 0) {
                nums[i] = nums[i - 1] / i * (rowIndex - i + 1);
            } else if ((rowIndex - i + 1) % i == 0) {
                nums[i] = (rowIndex - i + 1) / i * nums[i - 1];
            } else {
                nums[i] = (int) ((rowIndex - i + 1) * 1.0 * nums[i - 1] / i);
            }
            result.add(nums[i]);
        }
        for (int i = middle + 1; i <= rowIndex; i++) {
            nums[i] = nums[rowIndex - i];
            result.add(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution0119 solution = new Solution0119();
        int maxRowIndex = 33;
        for (int i = 0; i <= maxRowIndex; i++) {
            List<Integer> list = solution.getRow(i);
            System.out.print("[");
            for (Integer x : list) {
                System.out.print(x + ", ");
            }
            System.out.println("]");
        }
    }
}
