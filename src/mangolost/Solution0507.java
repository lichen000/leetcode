package mangolost;

//We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
//
//        Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
//        Example:
//        Input: 28
//        Output: True
//        Explanation: 28 = 1 + 2 + 4 + 7 + 14
//        Note: The input number n will not exceed 100,000,000. (1e8)

/**
 *
 */
public class Solution0507 {

    /**
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {
        if (num < 6) {
            return false;
        }
        int n = (int) Math.sqrt(num);
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            if (num % i == 0) {
                sum += i + num / i;
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        Solution0507 solution = new Solution0507();
        for (int i = 1; i <= 100000; i++) {
            if (solution.checkPerfectNumber(i)) {
                System.out.println(i);
            }
        }
    }
}