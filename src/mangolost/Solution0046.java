package mangolost;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a collection of distinct integers, return all possible permutations.
//
//        Example:
//
//        Input: [1,2,3]
//        Output:
//        [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
//        ]

/**
 *
 */
public class Solution0046 {

	/**
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length == 0) {
			//do nothing
		} else if (nums.length == 1) {
			List<Integer> sublist = new ArrayList<>();
			sublist.add(nums[0]);
			result.add(sublist);
		} else {
			List<Integer> list = new ArrayList<>();
			Arrays.sort(nums);
			doPermute(nums, list, result);
		}
		return result;
	}

	/**
	 * @param nums
	 * @param list
	 * @param result
	 */
	private static void doPermute(int[] nums, List<Integer> list, List<List<Integer>> result) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<>(list));
		} else {
			for (int num : nums) {
				if (list.contains(num)) {
					continue;
				}
				list.add(num);
				doPermute(nums, list, result);
				list.remove(list.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Solution0046 solution = new Solution0046();
		int[] nums = {1, 9, 3, 7, 6};
		List<List<Integer>> result = solution.permute(nums);
		System.out.println(result);
	}
}
