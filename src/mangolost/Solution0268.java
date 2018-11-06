package mangolost;

//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
//
//        Example 1:
//
//        Input: [3,0,1]
//        Output: 2
//        Example 2:
//
//        Input: [9,6,4,2,3,5,7,0,1]
//        Output: 8
//        Note:
//        Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

/**
 *
 */
public class Solution0268 {

	/**
	 * @param nums
	 * @return
	 */
	public int missingNumber(int[] nums) {
		int len = nums.length;
		int sum = len * (len + 1) / 2;
		for (int num : nums) {
			sum = sum - num;
		}
		return sum;
	}

	public static void main(String[] args) {
		Solution0268 solution = new Solution0268();
		int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
		System.out.println(solution.missingNumber(nums));
	}
}