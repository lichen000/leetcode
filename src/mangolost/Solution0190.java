package mangolost;

//Reverse bits of a given 32 bits unsigned integer.
//
//        Example:
//
//        Input: 43261596
//        Output: 964176192
//        Explanation: 43261596 represented in binary as 00000010100101000001111010011100,
//        return 964176192 represented in binary as 00111001011110000010100101000000.
//        Follow up:
//        If this function is called many times, how would you optimize it?

/**
 *
 */
public class Solution0190 {

    // you need treat n as an unsigned value

    /**
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int count = 0;
        for (int i = 31; i >= 0; i--) {
            count = (n >>> i & 1) << (31 - i) | count;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution0190 solution = new Solution0190();
        int num = 43261596;
        System.out.println(solution.reverseBits(num));
    }
}
