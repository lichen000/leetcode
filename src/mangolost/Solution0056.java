package mangolost;

//Given a collection of intervals, merge all overlapping intervals.
//
//		Example 1:
//
//		Input: [[1,3],[2,6],[8,10],[15,18]]
//		Output: [[1,6],[8,10],[15,18]]
//		Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//		Example 2:
//
//		Input: [[1,4],[4,5]]
//		Output: [[1,5]]
//		Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//		NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class Solution0056 {

    /**
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < len) {
            int low = intervals[i][0];
            int high = intervals[i][1];
            while (i < len - 1 && high >= intervals[i + 1][0]) {
                high = Math.max(high, intervals[i + 1][1]);
                i++;
            }
            list.add(new int[]{low, high});
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
//        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = new int[][]{{1, 4}, {4, 5}};
        Solution0056 solution = new Solution0056();
        int[][] result = solution.merge(intervals);
        System.out.println(Arrays.toString(result));
    }
}