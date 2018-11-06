package mangolost;

//Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
//        n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
//        Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//
//        Note: You may not slant the container and n is at least 2.

/**
 *
 */
public class Solution0011 {

	/**
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;
		while (left != right) {
			if (height[left] <= height[right]) {
				int minheight = height[left];
				int tempArea = minheight * (right - left);
				if (tempArea > maxArea) {
					maxArea = tempArea;
				}
				while (left != right) {
					if (height[left] <= minheight) {
						left++;
					} else {
						break;
					}
				}
			} else {
				int minheight = height[right];
				int tempArea = minheight * (right - left);
				if (tempArea > maxArea) {
					maxArea = tempArea;
				}
				while (left != right) {
					if (height[right] <= minheight) {
						right--;
					} else {
						break;
					}
				}
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		Solution0011 solution = new Solution0011();
		int n = 10;
		int[] height = new int[n];
		for (int i = 0; i < n; i++) {
			height[i] = (int) Math.floor(Math.random() * 100);
			System.out.print(height[i] + " ");
		}
		System.out.println();
		System.out.println(solution.maxArea(height));
	}
}