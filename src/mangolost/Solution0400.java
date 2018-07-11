package mangolost;

//Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
//
//        Note:
//        n is positive and will fit within the range of a 32-bit signed integer (n < 231).
//
//        Example 1:
//
//        Input:
//        3
//
//        Output:
//        3
//        Example 2:
//
//        Input:
//        11
//
//        Output:
//        0
//
//        Explanation:
//        The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.

/**
 *
 */
public class Solution0400 {

    /**
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        if (n <= 9) {
            return n;
        }
        int start = 1;
        int len = 1;
        long count = 9;
        while (n > len * count){
            n -= len * count;
            len++;
            start *= 10;
            count *= 10;
        }
        start += (n - 1) / len;
        return String.valueOf(start).charAt((n - 1) % len) - '0';
    }

    public static void main(String[] args) {
        Solution0400 solution = new Solution0400();
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + " : " + solution.findNthDigit(i));
        }
    }
}