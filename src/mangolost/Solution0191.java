package mangolost;

//Write a function that takes an unsigned integer and returns the checkNumber of '1' bits it has (also known as the Hamming weight).
//
//		Example 1:
//
//		Input: 11
//		Output: 3
//		Explanation: Integer 11 has binary representation 00000000000000000000000000001011
//		Example 2:
//
//		Input: 128
//		Output: 1
//		Explanation: Integer 128 has binary representation 00000000000000000000000010000000

/**
 *
 */
public class Solution0191 {

	/**
	 * @param n
	 * @return
	 */
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			int temp = n & 0x1;
			count += temp;
			n = n >>> 1;
		}
		return count;
	}

	public static void main(String[] args) {
		Solution0191 solution = new Solution0191();
		for (int i = 0; i <= 128; i++) {
			System.out.println(solution.hammingWeight(i));
		}
	}
}
