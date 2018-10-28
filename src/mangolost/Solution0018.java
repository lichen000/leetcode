package mangolost;

//Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
//        Note:
//
//        The solution set must not contain duplicate quadruplets.
//
//        Example:
//
//        Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
//
//        A solution set is:
//        [
//        [-1,  0, 0, 1],
//        [-2, -1, 1, 2],
//        [-2,  0, 0, 2]
//        ]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Solution0018 {

    /**
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution0018 solution = new Solution0018();
        int[] nums = {1, 9, 9, 3, 0, 7, 1, 6};
        int target = 25;
        List<List<Integer>> list = solution.fourSum(nums, target);
        for (List<Integer> subList : list) {
            for (Integer x : subList) {
                System.out.print(x);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
