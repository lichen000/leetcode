package mangolost;

//Given a non-empty array of integers, every element appears twice except for one. Find that single one.
//
//		Note:
//
//		Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
//		Example 1:
//
//		Input: [2,2,1]
//		Output: 1
//		Example 2:
//
//		Input: [4,1,2,1,2]
//		Output: 4

/**
 *
 */
public class Solution0136 {

    /**
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution0136 solution = new Solution0136();
        int[] nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(solution.singleNumber(nums));
    }
}
