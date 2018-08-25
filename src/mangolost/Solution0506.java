package mangolost;

//Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
//
//        Example 1:
//        Input: [5, 4, 3, 2, 1]
//        Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
//        Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
//        For the left two athletes, you just need to output their relative ranks according to their scores.
//        Note:
//        N is a positive integer and won't exceed 10,000.
//        All the scores of athletes are guaranteed to be unique.

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 */
public class Solution0506 {

    /**
     * @param nums
     * @return
     */
    public String[] findRelativeRanks(int[] nums) {
        int len = nums.length;
        String[] result = new String[len];
        if (len > 0) {
            Map<Integer, Integer> map = new TreeMap<>();
            for (int num : nums) {
                map.put(num, 0);
            }
            int rank = map.size();
            for (Map.Entry m : map.entrySet()) {
                int index = 0;
                while (index < len) {
                    if ((int) m.getKey() == nums[index]) {
                        break;
                    }
                    index++;
                }
                switch (rank) {
                    case 1:
                        result[index] = "Gold Medal";
                        break;
                    case 2:
                        result[index] = "Silver Medal";
                        break;
                    case 3:
                        result[index] = "Bronze Medal";
                        break;
                    default:
                        result[index] = String.valueOf(rank);
                        break;
                }
                rank--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution0506 solution = new Solution0506();
        int[] nums = new int[]{1, 6, 4, 3, 8, 5, 9, 0, 7, 2};
        String[] result = solution.findRelativeRanks(nums);
        System.out.println(Arrays.asList(result));
    }
}