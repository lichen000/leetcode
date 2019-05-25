package mangolost;

//Given a set of distinct integers, nums, return all possible subsets (the power set).
//
//		Note: The solution set must not contain duplicate subsets.
//
//		Example:
//
//		Input: nums = [1,2,3]
//		Output:
//		[
//		[3],
//		[1],
//		[2],
//		[1,2,3],
//		[1,3],
//		[2,3],
//		[1,2],
//		[]
//		]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Solution0078 {

    /**
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }
        depthFirstSearch(list, new ArrayList<>(), nums, 0);
        return list;
    }

    /**
     * @param list
     * @param tempList
     * @param nums
     * @param begin
     */
    private void depthFirstSearch(List<List<Integer>> list, List<Integer> tempList, int[] nums, int begin) {
        list.add(new ArrayList<>(tempList));
        for (int i = begin, len = nums.length; i < len; i++) {
            tempList.add(nums[i]);
            depthFirstSearch(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution0078 solution = new Solution0078();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> subSets = solution.subsets(nums);
        System.out.println("[");
        for (List<Integer> list : subSets) {
            System.out.println("    " + Arrays.toString(list.toArray()));
        }
        System.out.println("]");
    }
}
