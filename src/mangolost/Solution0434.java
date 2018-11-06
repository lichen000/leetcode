package mangolost;

//Count the checkNumber of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
//
//        Please note that the string does not contain any non-printable characters.
//
//        Example:
//
//        Input: "Hello, my name is John"
//        Output: 5


/**
 *
 */
public class Solution0434 {

	/**
	 * @param s
	 * @return
	 */
	public int countSegments(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int count = 0;
		int len = s.length();
		for (int i = 0; i < len - 1; i++) {
			if (s.charAt(i) == ' ' && s.charAt(i + 1) != ' ') {
				count++;
			}
		}
		return s.startsWith(" ") ? count : count + 1;
	}

	public static void main(String[] args) {
		Solution0434 solution = new Solution0434();
		String s = "Hello, my name is reainll";
		System.out.println(solution.countSegments(s));
	}
}