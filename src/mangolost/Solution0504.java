package mangolost;

//Given an integer, return its base 7 string representation.
//
//		Example 1:
//		Input: 100
//		Output: "202"
//		Example 2:
//		Input: -7
//		Output: "-10"
//		Note: The input will be in range of [-1e7, 1e7].

/**
 *
 */
public class Solution0504 {

    /**
     * @param num
     * @return
     */
    public String convertToBase7(int num) {
        if (num < 0) {
            return "-" + convertToBase7(-num);
        }
        if (num < 7) {
            return String.valueOf(num);
        }
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int yushu = num % 7;
            result.insert(0, String.valueOf(yushu));
            num = num / 7;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution0504 solution = new Solution0504();
        for (int i = 0; i <= 1000; i++) {
            System.out.println(i + " : " + solution.convertToBase7(i));
        }
    }
}