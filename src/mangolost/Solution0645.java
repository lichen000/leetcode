package mangolost;

//The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
//
//        Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
//
//        Example 1:
//        Input: nums = [1,2,2,4]
//        Output: [2,3]
//        Note:
//        The given array size will in the range [2, 10000].
//        The given array's numbers won't have any order.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class Solution0645 {

    /**
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int duplicate = 0, len = nums.length;
        int sum = (len * (len + 1)) / 2;
        for (int i : nums) {
            if (set.contains(i)) {
                duplicate = i;
            }
            sum = sum - i;
            set.add(i);
        }
        int missing = sum + duplicate;
        return new int[]{duplicate, missing};
    }

    public static void main(String[] args) {
        Solution0645 solution = new Solution0645();
        int[] nums = new int[]{1, 2, 2, 4};
        int[] y = solution.findErrorNums(nums);
        System.out.println(Arrays.toString(y));
    }
}