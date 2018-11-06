package mangolost;

//Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
//
//
//        In Pascal's triangle, each checkNumber is the sum of the two numbers directly above it.
//
//        Example:
//
//        Input: 5
//        Output:
//        [
//        [1],
//        [1,1],
//        [1,2,1],
//        [1,3,3,1],
//        [1,4,6,4,1]
//        ]

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Solution0118 {

	/**
	 * @param numRows
	 * @return
	 */
	public List<List<Integer>> generate(int numRows) {
		if (numRows == 0) {
			return new ArrayList<>();
		}
		List<List<Integer>> list = new ArrayList<>();
		for (int row = 0; row < numRows; row++) {
			list.add(new ArrayList<>());
		}
		list.get(0).add(1);
		if (numRows > 1) {
			list.get(1).add(1);
			list.get(1).add(1);
			for (int row = 2; row < numRows; row++) {
				List<Integer> currentRowList = list.get(row);
				List<Integer> upperRowList = list.get(row - 1);
				currentRowList.add(1);
				for (int column = 1; column < row; column++) {
					int temp = upperRowList.get(column - 1) + upperRowList.get(column);
					currentRowList.add(temp);
				}
				currentRowList.add(1);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		Solution0118 solution = new Solution0118();
		int numRows = 10;
		List<List<Integer>> list = solution.generate(numRows);
		for (List<Integer> subList : list) {
			System.out.print("[");
			for (Integer x : subList) {
				System.out.print(x + ", ");
			}
			System.out.println("]");
		}
	}
}
