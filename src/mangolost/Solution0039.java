package mangolost;

//Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//
//		The same repeated number may be chosen from candidates unlimited number of times.
//
//		Note:
//
//		All numbers (including target) will be positive integers.
//		The solution set must not contain duplicate combinations.
//		Example 1:
//
//		Input: candidates = [2,3,6,7], target = 7,
//		A solution set is:
//		[
//		[7],
//		[2,2,3]
//		]
//		Example 2:
//
//		Input: candidates = [2,3,5], target = 8,
//		A solution set is:
//		[
//		[2,2,2,2],
//		[2,3,3],
//		[3,5]
//		]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Solution0039 {

	/**
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		doRecursive(result, temp, candidates, 0, 0, target);
		return result;
	}

	/**
	 *
	 * @param result
	 * @param temp
	 * @param candidates
	 * @param index
	 * @param cursum
	 * @param target
	 */
	private void doRecursive(List<List<Integer>> result, List<Integer> temp, int[] candidates, int index, int cursum, int target) {
		if (cursum > target) {
			return;
		} else if (cursum == target) {
			result.add(new ArrayList<>(temp));
		}
		for (int i = index, len = candidates.length; i < len; i++) {
			temp.add(candidates[i]);
			doRecursive(result, temp, candidates, i, cursum + candidates[i], target);
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {
		Solution0039 solution = new Solution0039();
		int[] candidates = {9, 3, 1, 6};
		int target = 19;
		List<List<Integer>> result = solution.combinationSum(candidates, target);
		for (List list : result) {
			System.out.println(Arrays.toString(list.toArray()));
		}
	}
}
