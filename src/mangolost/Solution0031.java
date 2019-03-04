package mangolost;

//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//		If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
//		The replacement must be in-place and use only constant extra memory.
//
//		Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//
//		1,2,3 → 1,3,2
//		3,2,1 → 1,2,3
//		1,1,5 → 1,5,1

import java.util.Arrays;

/**
 *
 */
public class Solution0031 {

    /**
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        int i = len - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = len - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    /**
     *
     * @param nums
     * @param start
     */
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    /**
     *
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution0031 solution = new Solution0031();
        int[] nums = {8, 7, 1, 5};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
