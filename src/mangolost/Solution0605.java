package mangolost;

//Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
//
//        Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
//
//        Example 1:
//        Input: flowerbed = [1,0,0,0,1], n = 1
//        Output: True
//        Example 2:
//        Input: flowerbed = [1,0,0,0,1], n = 2
//        Output: False
//        Note:
//        The input array won't violate no-adjacent-flowers rule.
//        The input array size is in the range of [1, 20000].
//        n is a non-negative integer which won't exceed the input array size.

/**
 *
 */
public class Solution0605 {

    /**
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if (n > (len + 1) / 2) {
            return false;
        }
        int i = 0, count = 0;
        while (i < len) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == len - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            if (count >= n) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution0605 solution = new Solution0605();
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n1 = 1, n2 = 2;
        System.out.println(solution.canPlaceFlowers(flowerbed, n1));
        System.out.println(solution.canPlaceFlowers(flowerbed, n2));
    }
}