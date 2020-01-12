package mangolost;

//Given an integer n, return any array containing n unique integers such that they add up to 0.
//
//
//
//		Example 1:
//
//		Input: n = 5
//		Output: [-7,-1,1,3,4]
//		Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
//		Example 2:
//
//		Input: n = 3
//		Output: [-1,0,1]
//		Example 3:
//
//		Input: n = 1
//		Output: [0]
//
//
//		Constraints:
//
//		1 <= n <= 1000

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class Solution1304 {

	/**
	 *
	 * @param n
	 * @return
	 */
	public int[] sumZero(int n) {
		if (n == 1) {
			return new int[] {0};
		} else if (n == 2) {
			return new int[] {-1, 1};
		} else {
			int k = n / 2;
			int[] result = new int[n];
			result[0] = -k;
			for (int i = 1; i < n; i++) {
				result[i] = result[i - 1] + 1;
				if (n % 2 == 0) {
					if (result[i] == 0) {
						result[i] = 1;
					}
				}
			}
			return result;
		}
	}

	public static void main(String[] args) {
		Solution1304 solution = new Solution1304();
		for (int i = 1; i <= 20; i++) {
			int[] result = solution.sumZero(i);
			System.out.println(Arrays.toString(result));
		}

	}
}