package mangolost;

//Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//
//		For example:
//
//		1 -> A
//		2 -> B
//		3 -> C
//		...
//		26 -> Z
//		27 -> AA
//		28 -> AB
//		...
//		Example 1:
//
//		Input: 1
//		Output: "A"
//		Example 2:
//
//		Input: 28
//		Output: "AB"
//		Example 3:
//
//		Input: 701
//		Output: "ZY"

/**
 *
 */
public class Solution0168 {

	/**
	 *
	 * @param n
	 * @return
	 */
	public String convertToTitle(int n) {
		StringBuilder x = new StringBuilder();
		while (n != 0) {
			int yushu = (n - 1) % 26;
			x.insert(0, (char) ('A' + yushu));
			n = (n - 1) / 26;
		}
		return x.toString();
	}

	public static void main(String[] args) {
		Solution0168 solution = new Solution0168();
		for (int i = 1; i < 100; i++) {
			System.out.println(solution.convertToTitle(i));
		}
		System.out.println(solution.convertToTitle(701));
	}
}
