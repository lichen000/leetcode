package mangolost;

//Given two arrays, write a function to compute their intersection.
//
//        Example 1:
//
//        Input: nums1 = [1,2,2,1], nums2 = [2,2]
//        Output: [2,2]
//        Example 2:
//
//        Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//        Output: [4,9]
//        Note:
//
//        Each element in the result should appear as many times as it shows in both arrays.
//        The result can be in any order.
//        Follow up:
//
//        What if the given array is already sorted? How would you optimize your algorithm?
//        What if nums1's size is small compared to nums2's size? Which algorithm is better?
//        What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Solution0350 {

    /**
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0, len1 = nums1.length, len2 = nums2.length; i < len1 && j < len2; ) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0, len = result.length; i < len; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution0350 solution = new Solution0350();
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        int[] y = solution.intersect(nums1, nums2);
        System.out.println(Arrays.toString(y));
    }
}