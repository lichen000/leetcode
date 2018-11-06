package mangolost;

//Given two arrays, write a function to compute their intersection.
//
//        Example:
//        Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
//
//        Note:
//        Each element in the result must be unique.
//        The result can be in any order.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class Solution0349 {

	/**
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> interSet = new HashSet<>();
		for (int aNums1 : nums1) {
			set.add(aNums1);
		}
		for (int aNums2 : nums2) {
			if (set.contains(aNums2)) {
				interSet.add(aNums2);
			}
		}
		int[] result = new int[interSet.size()];
		int index = 0;
		for (int num : interSet) {
			result[index] = num;
			index++;
		}
		return result;
	}

	public static void main(String[] args) {
		Solution0349 solution = new Solution0349();
		int[] nums1 = new int[]{1, 2, 2, 1};
		int[] nums2 = new int[]{2, 2};
		int[] y = solution.intersection(nums1, nums2);
		System.out.println(Arrays.toString(y));
	}
}