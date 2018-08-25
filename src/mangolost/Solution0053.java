package mangolost;

//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
//		Example:
//
//		Input: [-2,1,-3,4,-1,2,1,-5,4],
//		Output: 6
//		Explanation: [4,-1,2,1] has the largest sum = 6.
//		Follow up:
//
//		If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

/**
 *
 */
public class Solution0053 {

    /**
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int sum = nums[0];
        int temp = nums[0];
        for (int i = 1; i < len; i++) {
            if (temp > 0) {
                temp += nums[i];
            } else {
                temp = nums[i];
            }
            if (sum < temp) {
                sum = temp;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution0053 solution = new Solution0053();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums));
    }
}