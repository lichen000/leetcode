package mangolost;

//Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
//
//        Example:
//        Given a = 1 and b = 2, return 3.

/**
 *
 */
public class Solution0371 {

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        while (b != 0) {
            int temp = a & b;
            a = a ^ b;
            b = temp << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution0371 solution = new Solution0371();
        System.out.println(solution.getSum(19870715, 19861201));
    }
}