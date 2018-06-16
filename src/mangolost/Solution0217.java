package mangolost;

//Given an array of integers, find if the array contains any duplicates.
//
//		Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
//
//		Example 1:
//
//		Input: [1,2,3,1]
//		Output: true
//		Example 2:
//
//		Input: [1,2,3,4]
//		Output: false
//		Example 3:
//
//		Input: [1,1,1,3,3,4,3,2,4,2]
//		Output: true

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class Solution0217 {

	/**
	 *
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length < 2) {
			return false;
		}
		Set<Integer> set = new HashSet<>();
		set.add(nums[0]);
		for (int i = 1, len = nums.length; i < len; i++) {
			if (set.contains(nums[i])) {
				return true;
			} else {
				set.add(nums[i]);
			}
		}
		return false;
	}

    public static void main(String[] args) {
        Solution0217 solution = new Solution0217();
        int[] nums = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(solution.containsDuplicate(nums));
    }
}
