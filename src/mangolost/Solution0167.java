package mangolost;

//Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target checkNumber.
//
//		The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
//
//		Note:
//
//		Your returned answers (both index1 and index2) are not zero-based.
//		You may assume that each input would have exactly one solution and you may not use the same element twice.
//		Example:
//
//		Input: numbers = [2,7,11,15], target = 9
//		Output: [1,2]
//		Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

/**
 *
 */
public class Solution0167 {

	/**
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length < 2) {
			return null;
		}
		int i = 0, j = numbers.length - 1;
		while (i < j) {
			int x = numbers[i] + numbers[j];
			if (x < target) {
				i++;
			} else if (x > target) {
				j--;
			} else {
				return new int[]{i + 1, j + 1};
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Solution0167 solution = new Solution0167();
		int[] nums = new int[]{2, 7, 11, 15};
		int target = 9;
		int[] result = solution.twoSum(nums, target);
		for (int x : result) {
			System.out.print(x + " ");
		}
	}
}
