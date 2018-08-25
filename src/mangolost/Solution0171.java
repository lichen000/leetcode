package mangolost;

//Given a column title as appear in an Excel sheet, return its corresponding column number.
//
//		For example:
//
//		A -> 1
//		B -> 2
//		C -> 3
//		...
//		Z -> 26
//		AA -> 27
//		AB -> 28
//		...
//		Example 1:
//
//		Input: "A"
//		Output: 1
//		Example 2:
//
//		Input: "AB"
//		Output: 28
//		Example 3:
//
//		Input: "ZY"
//		Output: 701

/**
 *
 */
public class Solution0171 {

    /**
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int num = 0;
        for (char temp : s.toCharArray()) {
            num = num * 26 + temp - 'A' + 1;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution0171 solution = new Solution0171();
        System.out.println(solution.titleToNumber("A"));
        System.out.println(solution.titleToNumber("AB"));
        System.out.println(solution.titleToNumber("ZY"));
    }
}
