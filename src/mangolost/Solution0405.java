package mangolost;

//Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
//
//        Note:
//
//        All letters in hexadecimal (a-f) must be in lowercase.
//        The hexadecimal string must not contain extra leading 0s. If the checkNumber is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
//        The given checkNumber is guaranteed to fit within the range of a 32-bit signed integer.
//        You must not use any method provided by the library which converts/formats the checkNumber to hex directly.
//        Example 1:
//
//        Input:
//        26
//
//        Output:
//        "1a"
//        Example 2:
//
//        Input:
//        -1
//
//        Output:
//        "ffffffff"

import java.util.Stack;

/**
 *
 */
public class Solution0405 {

	/**
	 * @param num
	 * @return
	 */
	public String toHex(int num) {
		if (num == 0) {
			return "0";
		}
		Stack<Character> stack = new Stack<>();
		char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		int count = 0;//用来记录是否已经到第32位
		while (num != 0 && count < 8) {
			int i = num & 0xf;//num低四位与16进制的f进行与运算，得到num的低四位16进制对应的整数
			stack.push(hex[i]);//查表，并入栈
			num = num >> 4;//右移四位
			count++;
		}
		StringBuilder s = new StringBuilder();
		while (!stack.isEmpty()) {
			s.append(stack.pop());
		}
		return s.toString();
	}

	public static void main(String[] args) {
		Solution0405 solution = new Solution0405();
		for (int i = -100; i <= 100; i++) {
			System.out.println(i + " : " + solution.toHex(i));
		}
	}
}
