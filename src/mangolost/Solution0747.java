package mangolost;

//In a given integer array nums, there is always exactly one largest element.
//
//		Find whether the largest element in the array is at least twice as much as every other number in the array.
//
//		If it is, return the index of the largest element, otherwise return -1.
//
//		Example 1:
//
//		Input: nums = [3, 6, 1, 0]
//		Output: 1
//		Explanation: 6 is the largest integer, and for every other number in the array x,
//		6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
//
//
//		Example 2:
//
//		Input: nums = [1, 2, 3, 4]
//		Output: -1
//		Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
//
//
//		Note:
//
//		nums will have a length in the range [1, 50].
//		Every nums[i] will be an integer in the range [0, 99].

import java.util.Arrays;

/**
 *
 */
public class Solution0747 {

    /**
     * @param nums
     * @return
     */
    public int dominantIndex(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int max = nums[0], index = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        Arrays.sort(nums);
        if (max >= 2 * nums[len - 2]) {
            return index;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution0747 solution = new Solution0747();
        int[] nums1 = new int[]{3, 6, 1, 0};
        System.out.println(solution.dominantIndex(nums1));

        int[] nums2 = new int[]{1, 2, 3, 4};
        System.out.println(solution.dominantIndex(nums2));

    }
}