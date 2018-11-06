package mangolost;

//Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//        Example:
//
//        Input: [0,1,0,3,12]
//        Output: [1,3,12,0,0]
//        Note:
//
//        You must do this in-place without making a copy of the array.
//        Minimize the total checkNumber of operations.

/**
 *
 */
public class Solution0283 {

	/**
	 * @param nums
	 */
	public void moveZeroes(int[] nums) {
		int len = nums.length;
		int index = 0;
		for (int i = index; i < len; i++) {
			if (nums[i] != 0) {
				if (i != index && nums[i] != nums[index]) {
					int temp = nums[i];
					nums[i] = nums[index];
					nums[index] = temp;
				}
				index++;
			}
		}
	}

	public static void main(String[] args) {
		Solution0283 solution = new Solution0283();
		int[] nums = new int[]{0, 1, 0, 3, 12};
		solution.moveZeroes(nums);
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}
}