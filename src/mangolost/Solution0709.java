package mangolost;

//Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
//
//		Example 1:
//
//		Input: "Hello"
//		Output: "hello"
//		Example 2:
//
//		Input: "here"
//		Output: "here"
//		Example 3:
//
//		Input: "LOVELY"
//		Output: "lovely"

/**
 *
 */
public class Solution0709 {

	/**
	 *
	 * @param str
	 * @return
	 */
	public String toLowerCase(String str) {
		StringBuilder result = new StringBuilder();
		for (char ch: str.toCharArray()) {
			if (ch >= 'A' && ch <= 'Z') {
				ch += 32;
			}
			result.append(String.valueOf(ch));
		}
		return result.toString();
	}

    public static void main(String[] args) {
        Solution0709 solution = new Solution0709();
        String x = "Hello, Reainll!";
        System.out.println(solution.toLowerCase(x));
    }
}