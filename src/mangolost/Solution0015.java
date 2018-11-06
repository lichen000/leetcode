package mangolost;

//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//        Note:
//
//        The solution set must not contain duplicate triplets.
//
//        Example:
//
//        Given array nums = [-1, 0, 1, 2, -1, -4],
//
//        A solution set is:
//        [
//        [-1, 0, 1],
//        [-1, -1, 2]
//        ]

import java.util.*;

/**
 *
 */
public class Solution0015 {

	/**
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		int len = nums.length;
		if (len < 3) {
			return result;
		}
		Arrays.sort(nums);
		Set<List<Integer>> set = new HashSet<>();
		for (int i = 0; i < len - 2; i++) {
			if (nums[i] > 0) {
				break;
			}
			int low = i + 1;
			int high = len - 1;
			while (low < high) {
				if (nums[low] + nums[high] + nums[i] == 0) {
					if (!set.contains(Arrays.asList(nums[i], nums[low], nums[high]))) {
						set.add(Arrays.asList(nums[i], nums[low], nums[high]));
						result.add(Arrays.asList(nums[i], nums[low], nums[high]));
					}
					while (low < high && nums[low] == nums[low + 1]) {
						low++;
					}
					while (low < high && nums[high] == nums[high - 1]) {
						high--;
					}
					low++;
					high--;
				} else if (nums[low] + nums[high] + nums[i] > 0) {
					high--;
				} else {
					low++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution0015 solution = new Solution0015();
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> list = solution.threeSum(nums);
		for (List<Integer> aList : list) {
			System.out.print("[ ");
			for (Integer anAList : aList) {
				System.out.print(anAList + " ");
			}
			System.out.println("]");
		}
	}
}
