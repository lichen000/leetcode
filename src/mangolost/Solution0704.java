package mangolost;

//Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.
//
//
//        Example 1:
//
//        Input: nums = [-1,0,3,5,9,12], target = 9
//        Output: 4
//        Explanation: 9 exists in nums and its index is 4
//
//        Example 2:
//
//        Input: nums = [-1,0,3,5,9,12], target = 2
//        Output: -1
//        Explanation: 2 does not exist in nums so return -1
//
//
//        Note:
//
//        You may assume that all elements in nums are unique.
//        n will be in the range [1, 10000].
//        The value of each element in nums will be in the range [-9999, 9999].

/**
 *
 */
public class Solution0704 {

	/**
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search(int[] nums, int target) {
		int len = nums.length;
		int left = 0;
		int right = len - 1;
		int middle = (left + right) / 2;
		while (left <= right) {
			if (nums[left] == target) {
				return left;
			}
			if (nums[right] == target) {
				return right;
			}
			middle = (left + right) / 2;
			if (nums[middle] == target) {
				return middle;
			} else if (nums[middle] > target) {
				left++;
				right = middle;
			} else if (nums[middle] < target) {
				left = middle;
				right--;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Solution0704 solution = new Solution0704();
		int[] nums = {7, 15, 16, 87, 93, 715, 716, 1987, 1993, 2017, 2018};
		int target = 716;
		System.out.println(solution.search(nums, target));
	}
}