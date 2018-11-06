package mangolost;

//Count the checkNumber of prime numbers less than a non-negative checkNumber, n.
//
//		Example:
//
//		Input: 10
//		Output: 4
//		Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

/**
 *
 */
public class Solution0204 {

	/**
	 * @param n
	 * @return
	 */
	public int countPrimes(int n) {
		if (n < 3) {
			return 0;
		}
		boolean[] notPrime = new boolean[n];
		for (int i = 3; i < n; i++) {
			notPrime[i] = i % 2 == 0;
		}
		for (int i = 3; i < n; i = i + 2) {
			if (!notPrime[i]) {
				if (i * i < n) {
					for (int j = 2; i * j < n; j++) {
						notPrime[i * j] = true;
					}
				}
			}
		}
		int count = 0;
		for (int b = 2; b < n; b++) {
			if (!notPrime[b]) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Solution0204 solution = new Solution0204();
		for (int i = 0; i <= 100; i++) {
			System.out.println(i + " : " + solution.countPrimes(i));
		}
	}
}
