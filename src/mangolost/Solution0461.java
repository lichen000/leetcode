package mangolost;

//The Hamming distance between two integers is the checkNumber of positions at which the corresponding bits are different.
//
//        Given two integers x and y, calculate the Hamming distance.
//
//        Note:
//        0 ≤ x, y < 231.
//
//        Example:
//
//        Input: x = 1, y = 4
//
//        Output: 2
//
//        Explanation:
//        1   (0 0 0 1)
//        4   (0 1 0 0)
//        ↑   ↑
//
//        The above arrows point to positions where the corresponding bits are different.

/**
 *
 */
public class Solution0461 {

	/**
	 * @param x
	 * @param y
	 * @return
	 */
	public int hammingDistance(int x, int y) {
		if (x == y) {
			return 0;
		}
		int z = x ^ y;
		int result = 0;
		while (z != 0) {
			if (z % 2 == 1) {
				result++;
			}
			z = z / 2;
		}
		return result;
	}

	public static void main(String[] args) {
		Solution0461 solution = new Solution0461();
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				System.out.println(i + " : " + j + " : " + solution.hammingDistance(i, j));
			}
		}
	}
}