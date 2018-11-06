package mangolost;

//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
//		You may assume that the array is non-empty and the majority element always exist in the array.
//
//		Example 1:
//
//		Input: [3,2,3]
//		Output: 3
//		Example 2:
//
//		Input: [2,2,1,1,1,2,2]
//		Output: 2

/**
 *
 */
public class Solution0169 {

	/**
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
		if (nums.length < 3) {
			return nums[0];
		}
		int result = nums[0], times = 1;
		for (int i = 1, len = nums.length; i < len; i++) {
			if (nums[i] == result) {
				times++;
			} else if (times == 0) {
				result = nums[i];
				times++;
			} else {
				times--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution0169 solution = new Solution0169();
		int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
		System.out.println(solution.majorityElement(nums));
	}
}
