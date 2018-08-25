package mangolost;

//Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
//
//        Example:
//        Given num = 16, return true. Given num = 5, return false.
//
//        Follow up: Could you solve it without loops/recursion?

/**
 *
 */
public class Solution0342 {

    /**
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {
        while (num != 0 && num % 4 == 0) {
            num = num / 4;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        Solution0342 solution = new Solution0342();
        for (int i = 1; i <= 10000; i++) {
            if (solution.isPowerOfFour(i)) {
                System.out.println(i + " : " + solution.isPowerOfFour(i));
            }
        }
    }
}