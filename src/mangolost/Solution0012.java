package mangolost;

//Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
//        Symbol       Value
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
//        For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The checkNumber twenty seven is written as XXVII, which is XX + V + II.
//
//        Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the checkNumber four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the checkNumber nine, which is written as IX. There are six instances where subtraction is used:
//
//        I can be placed before V (5) and X (10) to make 4 and 9.
//        X can be placed before L (50) and C (100) to make 40 and 90.
//        C can be placed before D (500) and M (1000) to make 400 and 900.
//        Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
//
//        Example 1:
//
//        Input: 3
//        Output: "III"
//        Example 2:
//
//        Input: 4
//        Output: "IV"
//        Example 3:
//
//        Input: 9
//        Output: "IX"
//        Example 4:
//
//        Input: 58
//        Output: "LVIII"
//        Explanation: C = 100, L = 50, XXX = 30 and III = 3.
//        Example 5:
//
//        Input: 1994
//        Output: "MCMXCIV"
//        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

/**
 *
 */
public class Solution0012 {

	/**
	 * @param num
	 * @return
	 */
	public String intToRoman(int num) {
		String[] qianwei = {"", "M", "MM", "MMM"};
		String[] baiwei = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String[] shiwei = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String[] gewei = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		return qianwei[num / 1000] + baiwei[(num % 1000) / 100] + shiwei[(num % 100) / 10] + gewei[num % 10];
	}

	public static void main(String[] args) {
		Solution0012 solution = new Solution0012();
		for (int i = 1; i < 2000; i++) {
			System.out.println(i + " : " + solution.intToRoman(i));
		}
	}
}