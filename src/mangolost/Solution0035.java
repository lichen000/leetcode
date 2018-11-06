package mangolost;

//Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
//        You may assume no duplicates in the array.
//
//        Example 1:
//
//        Input: [1,3,5,6], 5
//        Output: 2
//        Example 2:
//
//        Input: [1,3,5,6], 2
//        Output: 1
//        Example 3:
//
//        Input: [1,3,5,6], 7
//        Output: 4
//        Example 4:
//
//        Input: [1,3,5,6], 0
//        Output: 0

/**
 *
 */
public class Solution0035 {

	/**
	 * @param nums
	 * @param target
	 * @return
	 */
	public int searchInsert(int[] nums, int target) {
		int left = 0, right = nums.length - 1, middle = 0, position = 0;
		while (left <= right) {
			middle = (left + right) / 2;
			if (target == nums[middle]) {
				return middle;
			} else if (target > nums[middle]) {
				left = middle + 1;
				position = middle + 1;
			} else {
				right = middle - 1;
				position = middle;
			}
		}
		return position;
	}

	public static void main(String[] args) {
		Solution0035 solution = new Solution0035();
		int[] nums = new int[]{1, 3, 5, 6};
		int target = 5;
		System.out.println(solution.searchInsert(nums, target));
	}
}
