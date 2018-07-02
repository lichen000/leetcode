package mangolost;

//Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
//
//        Example 1:
//        Input: [1,12,-5,-6,50,3], k = 4
//        Output: 12.75
//        Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
//        Note:
//        1 <= k <= n <= 30,000.
//        Elements of the given array will be in the range [-10,000, 10,000].

/**
 *
 */
public class Solution0643 {

    /**
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;
        for (int i = 0; i < k; ++i) {
            sum += nums[i];
        }
        double current = sum;
        double max = current;
        for (int i = k, len = nums.length; i < len; ++i) {
            current = current + nums[i] - nums[i - k];
            if (current > max) {
                max = current;
            }
        }
        return max / k;
    }

    public static void main(String[] args) {
        Solution0643 solution = new Solution0643();
        int[] nums = new int[]{1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(solution.findMaxAverage(nums, k));
    }
}