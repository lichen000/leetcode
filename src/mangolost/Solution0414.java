package mangolost;

//Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
//
//        Example 1:
//        Input: [3, 2, 1]
//
//        Output: 1
//
//        Explanation: The third maximum is 1.
//        Example 2:
//        Input: [1, 2]
//
//        Output: 2
//
//        Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
//        Example 3:
//        Input: [2, 2, 3, 1]
//
//        Output: 1
//
//        Explanation: Note that the third maximum here means the third maximum distinct number.
//        Both numbers with value 2 are both considered as second maximum.

/**
 *
 */
public class Solution0414 {

    /**
     *
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second && num < first) {
                third = second;
                second = num;
            } else if (num > third && num < second) {
                third = num;
            }
        }
        if (third == second || third == Long.MIN_VALUE) {
            return (int)first;
        } else {
            return (int)third;
        }
    }

    public static void main(String[] args) {
        Solution0414 solution = new Solution0414();
        int[] nums = {93, 87, 15, 16, 7, 102, 16};
        System.out.println(solution.thirdMax(nums));
    }
}