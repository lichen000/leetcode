package mangolost;

//Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//        Example:
//
//        Given array nums = [-1, 2, 1, -4], and target = 1.
//
//        The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

import java.util.Arrays;

/**
 *
 */
public class Solution0016 {

	/**
	 * @param nums
	 * @param target
	 * @return
	 */
	public int threeSumClosest(int[] nums, int target) {
		//assert that len >= 3
		int len = nums.length;
		if (len == 3) {
			return nums[0] + nums[1] + nums[2];
		}
		Arrays.sort(nums);
		int sum = nums[0] + nums[1] + nums[2];
		if (target == sum) {
			return target;
		}
		for (int i = 0; i < len - 2; i++) {
			int left = i + 1;
			int right = len - 1;
			while (left < right) {
				int temp = nums[i] + nums[left] + nums[right];
				if (temp == target) {
					return target;
				} else if (temp < target) {
					left++;
				} else {
					right--;
				}
				if (Math.abs(target - temp) < Math.abs(target - sum)) {
					sum = temp;
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Solution0016 solution = new Solution0016();
		int[] nums = {1, 9, 9, 3, 0, 7, 1, 6};
		int target = 25;
		int result = solution.threeSumClosest(nums, target);
		System.out.println(result);
	}
}
