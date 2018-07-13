package mangolost;

//Given a binary array, find the maximum number of consecutive 1s in this array.
//
//        Example 1:
//        Input: [1,1,0,1,1,1]
//        Output: 3
//        Explanation: The first two digits or the last three digits are consecutive 1s.
//        The maximum number of consecutive 1s is 3.
//        Note:
//
//        The input array will only contain 0 and 1.
//        The length of input array is a positive integer and will not exceed 10,000

import java.util.Arrays;

/**
 *
 */
public class Solution0485 {

    /**
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int temp = 0;
        for (int num : nums) {
            if (num == 1) {
                temp++;
            } else {
                if (temp > result) {
                    result = temp;
                }
                temp = 0;
            }
        }
        if (temp > result) {
            result = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution0485 solution = new Solution0485();
        int n = 100;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            double x = Math.random();
            if (x < 0.5) {
                nums[i] = 0;
            } else {
                nums[i] = 1;
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(solution.findMaxConsecutiveOnes(nums));
    }
}