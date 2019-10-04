package mangolost;

//Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
//
//		Example 1:
//		Input: [3, 1, 4, 1, 5], k = 2
//		Output: 2
//		Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
//		Although we have two 1s in the input, we should only return the number of unique pairs.
//		Example 2:
//		Input:[1, 2, 3, 4, 5], k = 1
//		Output: 4
//		Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
//		Example 3:
//		Input: [1, 3, 1, 5, 4], k = 0
//		Output: 1
//		Explanation: There is one 0-diff pair in the array, (1, 1).
//		Note:
//		The pairs (i, j) and (j, i) count as the same pair.
//		The length of the array won't exceed 10,000.
//		All the integers in the given input belong to the range: [-1e7, 1e7].

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Solution0532 {

	/**
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findPairs(int[] nums, int k) {
		int result = 0;
		int len = nums.length;
		if (len < 2 || k < 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < len; i++) {
			int val = nums[i] + k;
			if (map.containsKey(val) && map.get(val) != i) {
				result++;
				map.remove(val);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution0532 solution = new Solution0532();
		int[] nums1 = {3, 1, 4, 1, 5};
		int k1 = 2;
		System.out.println(solution.findPairs(nums1, k1));
		int[] nums2 = {1, 2, 3, 4, 5};
		int k2 = 1;
		System.out.println(solution.findPairs(nums2, k2));
		int[] nums3 = {1, 3, 1, 5, 4};
		int k3 = 0;
		System.out.println(solution.findPairs(nums3, k3));
	}
}
