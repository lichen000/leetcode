package mangolost;

//Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.
//
//        Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)
//
//        Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.
//
//        If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
//
//
//
//        Example 1:
//
//        Input: A = [1,1], B = [2,2]
//        Output: [1,2]
//        Example 2:
//
//        Input: A = [1,2], B = [2,3]
//        Output: [1,2]
//        Example 3:
//
//        Input: A = [2], B = [1,3]
//        Output: [2,3]
//        Example 4:
//
//        Input: A = [1,2,5], B = [2,4]
//        Output: [5,4]
//
//
//        Note:
//
//        1 <= A.length <= 10000
//        1 <= B.length <= 10000
//        1 <= A[i] <= 100000
//        1 <= B[i] <= 100000
//        It is guaranteed that Alice and Bob have different total amounts of candy.
//        It is guaranteed there exists an answer.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class Solution0888 {

    /**
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int totalA = 0, totalB = 0;
        for (int x : A) {
            totalA += x;
        }
        for (int x : B) {
            totalB += x;
        }
        int gap = (totalB - totalA) / 2;
        Set<Integer> setB = new HashSet<>();
        for (int x : B) {
            setB.add(x);
        }
        for (int x : A) {
            int temp = x + gap;
            if (setB.contains(temp)) {
                return new int[]{x, temp};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution0888 solution = new Solution0888();
        int[] A1 = {1, 1}, B1 = {2, 2};
        int[] A2 = {1, 2}, B2 = {2, 3};
        int[] A3 = {2}, B3 = {1, 3};
        int[] A4 = {1, 2, 5}, B4 = {2, 4};
        System.out.println(Arrays.toString(solution.fairCandySwap(A1, B1)));
        System.out.println(Arrays.toString(solution.fairCandySwap(A2, B2)));
        System.out.println(Arrays.toString(solution.fairCandySwap(A3, B3)));
        System.out.println(Arrays.toString(solution.fairCandySwap(A4, B4)));
    }
}