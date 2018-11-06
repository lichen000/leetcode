package mangolost;

//Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
//
//		Example 1:
//
//		Input: nums = [1,2,3,1], k = 3
//		Output: true
//		Example 2:
//
//		Input: nums = [1,0,1,1], k = 1
//		Output: true
//		Example 3:
//
//		Input: nums = [1,2,3,1,2,3], k = 2
//		Output: false

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Solution0219 {

	/**
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0, len = nums.length; i < len; i++) {
			if (map.containsKey(nums[i])) {
				if (Math.abs(i - map.get(nums[i])) <= k) {
					return true;
				} else {
					map.put(nums[i], i);
				}
			} else {
				map.put(nums[i], i);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Solution0219 solution = new Solution0219();
		int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
		int k = 3;
		System.out.println(solution.containsNearbyDuplicate(nums, k));
	}
}
