package mangolost;

//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//        Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
//
//        Example 1:
//
//        Input: [1,2,3,1]
//        Output: 4
//        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//        Total amount you can rob = 1 + 3 = 4.
//        Example 2:
//
//        Input: [2,7,9,3,1]
//        Output: 12
//        Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//        Total amount you can rob = 2 + 9 + 1 = 12.

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Solution0198 {

    private Map<Integer, Integer> map = new HashMap<>();

    /**
     *
     * @param index
     * @param nums
     * @return
     */
    public int rob2(int index, int[] nums) {
        if (nums.length <= index) {
            return 0;
        } else if (nums.length == index + 1) {
            return nums[index];
        } else {

            int index2 = index + 3;
            int sum2_x = 0;
            if (map.containsKey(index2)) {
                sum2_x = map.get(index2);
            } else {
                sum2_x = rob2(index + 3, nums);
                map.put(index2, sum2_x);
            }
            int sum2 = nums[index + 1] + sum2_x;

            int index1 = index + 2;
            int sum1_x = 0;
            if (map.containsKey(index1)) {
                sum1_x = map.get(index1);
            } else {
                sum1_x = rob2(index + 2, nums);
                map.put(index1, sum1_x);
            }
            int sum1 = nums[index] + sum1_x;
            return sum1 > sum2 ? sum1 : sum2;
        }
    }

    /**
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        } else {
            int sum1 = nums[0] + rob2(2, nums);
            int sum2 = nums[1] + rob2(3, nums);
            return sum1 > sum2 ? sum1 : sum2;
        }
    }

    public static void main(String[] args) {
        Solution0198 solution = new Solution0198();
        int[] nums = new int[]{226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124};
        System.out.println(solution.rob(nums));
    }
}
