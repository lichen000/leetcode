package mangolost;


/**
 *
 */
public class Solution0027 {

    /**
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int len2 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[len2] = nums[i];
                len2++;
            }
        }
        return len2;
    }

    public static void main(String[] args) {
        Solution0027 solution0026 = new Solution0027();
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int len = solution0026.removeElement(nums, val);
        System.out.println("len=" + len);
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }
}
