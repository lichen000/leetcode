package mangolost;

//Write an algorithm to determine if a number is "happy".
//
//		A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
//
//		Example:
//
//		Input: 19
//		Output: true
//		Explanation:
//		12 + 92 = 82
//		82 + 22 = 68
//		62 + 82 = 100
//		12 + 02 + 02 = 1

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public class Solution0202 {

	/**
	 *
	 * @param n
	 * @return
	 */
	public boolean isHappy(int n) {
		if (n == 1) {
			return true;
		}
		Set<Integer> set = new HashSet<>();
		while (n != 1 && !set.contains(n)) {
			set.add(n);
			n = getNext(n);
		}
		return n == 1;
	}

	/**
	 * 输入整数各位数字的平方和
	 * @param input a positive integer
	 */
	private int getNext(int input) {
		if (input < 10) {
			return input * input;
		}
		String str = String.valueOf(input);
		int result = 0;
		for (char x: str.toCharArray()) {
			int temp = x - '0';
			result += temp * temp;
		}
		return result;
	}

    public static void main(String[] args) {
		Solution0202 solution0202 = new Solution0202();
        for (int i = 1; i <= 100; i++) {
        	System.out.println(i + " : " + solution0202.isHappy(i));
		}
    }
}
