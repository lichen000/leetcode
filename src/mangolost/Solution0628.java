package mangolost;

//Given an integer array, find three numbers whose product is maximum and output the maximum product.
//
//        Example 1:
//        Input: [1,2,3]
//        Output: 6
//        Example 2:
//        Input: [1,2,3,4]
//        Output: 24
//        Note:
//        The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
//        Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.

import java.util.Arrays;

/**
 *
 */
public class Solution0628 {

    /**
     *
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int len = nums.length;
        int a = nums[len - 1] * nums[len - 2] * nums[len - 3];
        int b = nums[0] * nums[1] * nums[len - 1];
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        Solution0628 solution = new Solution0628();
        int[] nums = new int[]{1,2,3,4};
        System.out.println((solution.maximumProduct(nums)));
    }
}