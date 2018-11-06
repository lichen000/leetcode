package mangolost;

//The string "PAYPALISHIRING" is written in a zigzag pattern on a given checkNumber of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
//		P   A   H   N
//		A P L S I I G
//		Y   I   R
//		And then read line by line: "PAHNAPLSIIGYIR"
//
//		Write the code that will take a string and make this conversion given a checkNumber of rows:
//
//		string convert(string s, int numRows);
//		Example 1:
//
//		Input: s = "PAYPALISHIRING", numRows = 3
//		Output: "PAHNAPLSIIGYIR"
//		Example 2:
//
//		Input: s = "PAYPALISHIRING", numRows = 4
//		Output: "PINALSIGYAHRPI"
//		Explanation:
//
//		P     I    N
//		A   L S  I G
//		Y A   H R
//		P     I

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Solution0006 {

	/**
	 * @param s
	 * @param numRows
	 * @return
	 */
	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		List<StringBuilder> rows = new ArrayList<>();
		for (int i = 0, len = Math.min(numRows, s.length()); i < len; i++) {
			rows.add(new StringBuilder());
		}
		int curRow = 0;
		boolean goingDown = false;
		for (char c : s.toCharArray()) {
			rows.get(curRow).append(c);
			if (curRow == 0 || curRow == numRows - 1) {
				goingDown = !goingDown;
			}
			curRow += goingDown ? 1 : -1;
		}
		StringBuilder sb = new StringBuilder();
		for (StringBuilder row : rows) {
			sb.append(row);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution0006 solution = new Solution0006();
		String s = "MANGOLOST";
		int numRows = 3;
		System.out.println(solution.convert(s, numRows));
	}
}
