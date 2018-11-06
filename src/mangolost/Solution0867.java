package mangolost;

//Given a matrix A, return the transpose of A.
//
//        The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
//
//
//
//        Example 1:
//
//        Input: [[1,2,3],[4,5,6],[7,8,9]]
//        Output: [[1,4,7],[2,5,8],[3,6,9]]
//        Example 2:
//
//        Input: [[1,2,3],[4,5,6]]
//        Output: [[1,4],[2,5],[3,6]]
//
//
//        Note:
//
//        1 <= A.length <= 1000
//        1 <= A[0].length <= 1000

/**
 *
 */
public class Solution0867 {

	/**
	 * @param A
	 * @return
	 */
	public int[][] transpose(int[][] A) {
		int len1 = A.length, len2 = A[0].length;
		int[][] transpose = new int[len2][len1];
		for (int i = 0; i < len1; i++)
			for (int j = 0; j < len2; j++) {
				transpose[j][i] = A[i][j];
			}
		return transpose;
	}

	/**
	 * @param matrix
	 */
	public void printMatrix(int[][] matrix) {
		System.out.println();
		for (int[] aMatrix : matrix) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(aMatrix[j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Solution0867 solution = new Solution0867();
		int[][] nums1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		solution.printMatrix(solution.transpose(nums1));

		int[][] nums2 = {{1, 2, 3}, {4, 5, 6}};
		solution.printMatrix(solution.transpose(nums2));
	}
}