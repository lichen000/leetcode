package mangolost;

//Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
//
//        To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
//
//        To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
//
//        Example 1:
//
//        Input: [[1,1,0],[1,0,1],[0,0,0]]
//        Output: [[1,0,0],[0,1,0],[1,1,1]]
//        Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
//        Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
//        Example 2:
//
//        Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
//        Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//        Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
//        Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//        Notes:
//
//        1 <= A.length = A[0].length <= 20
//        0 <= A[i][j] <= 1

import java.util.Arrays;

/**
 *
 */
public class Solution0832 {

	/**
	 * @param A
	 * @return
	 */
	public int[][] flipAndInvertImage(int[][] A) {
		int[][] result = new int[A.length][];
		for (int i = 0, len = A.length; i < len; i++) {
			int len2 = A[i].length;
			int[] mid = new int[len2];
			for (int j = 0; j < len2; j++) {
				mid[j] = A[i][len2 - 1 - j] ^ 1;
			}
			result[i] = mid;
		}
		return result;
	}

	public static void main(String[] args) {
		Solution0832 solution = new Solution0832();
		int[][] x1 = new int[][]{
				{1, 1, 0},
				{1, 0, 1},
				{0, 0, 0}
		};
		int[][] x2 = new int[][]{
				{1, 1, 0, 0},
				{1, 0, 0, 1},
				{0, 1, 1, 1},
				{1, 0, 1, 0}
		};
		System.out.println();
		int[][] y1 = solution.flipAndInvertImage(x1);
		for (int[] aY1 : y1) {
			System.out.println(Arrays.toString(aY1));
		}

		int[][] y2 = solution.flipAndInvertImage(x2);
		System.out.println();
		for (int[] aY2 : y2) {
			System.out.println(Arrays.toString(aY2));
		}

	}
}