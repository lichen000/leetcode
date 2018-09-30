package mangolost;

//Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
//
//        You may return any answer array that satisfies this condition.
//
//
//
//        Example 1:
//
//        Input: [3,1,2,4]
//        Output: [2,4,3,1]
//        The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
//
//
//        Note:
//
//        1 <= A.length <= 5000
//        0 <= A[i] <= 5000


import java.util.Arrays;

/**
 *
 */
public class Solution0905 {

    /**
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        int len = A.length;
        if (len < 2) {
            return A;
        }
        int i = 0;
        int j = len - 1;
        while (i < j) {
            while (i < j && A[i] % 2 == 0) {
                i++;
            }
            if (A[i] % 2 == 1) {
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
                j--;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        Solution0905 solution = new Solution0905();
        int[] input = {9, 3, 0, 7, 1, 6};
        int[] output = solution.sortArrayByParity(input);
        System.out.println((Arrays.toString(output)));
    }
}