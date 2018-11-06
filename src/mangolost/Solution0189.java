package mangolost;


import java.util.Arrays;

/**
 *
 */
public class Solution0189 {

	/**
	 * @param nums
	 * @param k
	 */
	public void rotate(int[] nums, int k) {
		int len = nums.length;
		int k2 = k % len;
		int temp = 0;
		for (int i = 0; i < k2; i++) {
			temp = nums[len - 1];
			System.arraycopy(nums, 0, nums, 1, len - 2 + 1);
			nums[0] = temp;
		}
	}

	public static void main(String[] args) {
		Solution0189 solution = new Solution0189();
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		int k = 3;
		solution.rotate(nums, k);
		System.out.println(Arrays.toString(nums));
	}
}
