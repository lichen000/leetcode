package mangolost;


/**
 *
 */
public class Solution0415 {

	/**
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int len1 = num1.length(), len2 = num2.length();
		int mark = 0;
		int i = 0;
		while (i < len1 || i < len2) {
			int n1 = (i < len1) ? num1.charAt(len1 - i - 1) - '0' : 0;
			int n2 = (i < len2) ? num2.charAt(len2 - i - 1) - '0' : 0;
			int num = (n1 + n2 + mark) % 10;
			sb.append(num);
			mark = (n1 + n2 + mark) / 10;
			i++;
		}
		return (mark == 0) ? sb.reverse().toString() : sb.append(mark).reverse().toString();
	}

	public static void main(String[] args) {
		Solution0415 solution = new Solution0415();
		String num1 = "19870715";
		String num2 = "20181117";
		System.out.println(solution.addStrings(num1, num2));
	}
}