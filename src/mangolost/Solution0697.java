package mangolost;

//Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
//
//		Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
//
//		Example 1:
//		Input: [1, 2, 2, 3, 1]
//		Output: 2
//		Explanation:
//		The input array has a degree of 2 because both elements 1 and 2 appear twice.
//		Of the subarrays that have the same degree:
//		[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//		The shortest length is 2. So return 2.
//		Example 2:
//		Input: [1,2,2,3,1,4,2]
//		Output: 6
//		Note:
//
//		nums.length will be between 1 and 50,000.
//		nums[i] will be an integer between 0 and 49,999.

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Solution0697 {

    /**
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }
        int length = len;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!left.containsKey(nums[i])) {
                left.put(nums[i], i);
            }
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        int degree = Collections.max(count.values());
        for (int num : nums) {
            if (count.get(num) == degree) {
                length = Math.min(length, right.get(num) - left.get(num) + 1);
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Solution0697 solution = new Solution0697();
        int[] x = {1, 2, 2, 3, 1};
        System.out.println(solution.findShortestSubArray(x));

        int[] y = {1, 2, 2, 3, 1, 4, 2};
        System.out.println(solution.findShortestSubArray(y));
    }
}