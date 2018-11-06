package mangolost;

//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//
//        Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//
//        You may assume nums1 and nums2 cannot be both empty.
//
//
//
//        Example 1:
//
//        nums1 = [1, 3]
//        nums2 = [2]
//
//        The median is 2.0
//        Example 2:
//
//        nums1 = [1, 2]
//        nums2 = [3, 4]
//
//        The median is (2 + 3)/2 = 2.5

/**
 *
 */
public class Solution0004 {

	/**
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double result = 0;
		int len1 = nums1.length;
		int len2 = nums2.length;
		if (len1 > len2) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
			int tmp = len1;
			len1 = len2;
			len2 = tmp;
		}
		int iMin = 0, iMax = len1, halfLen = (len1 + len2 + 1) / 2;
		while (iMin <= iMax) {
			int i = (iMin + iMax) / 2;
			int j = halfLen - i;
			if (i < iMax && nums2[j - 1] > nums1[i]) {
				iMin = i + 1;
			} else if (i > iMin && nums1[i - 1] > nums2[j]) {
				iMax = i - 1;
			} else {
				int maxLeft = 0;
				if (i == 0) {
					maxLeft = nums2[j - 1];
				} else if (j == 0) {
					maxLeft = nums1[i - 1];
				} else {
					maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
				}
				if ((len1 + len2) % 2 == 1) {
					return maxLeft;
				}
				int minRight = 0;
				if (i == len1) {
					minRight = nums2[j];
				} else if (j == len2) {
					minRight = nums1[i];
				} else {
					minRight = Math.min(nums2[j], nums1[i]);
				}
				result = (maxLeft + minRight) / 2.0;
				return result;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution0004 solution = new Solution0004();
		int[] nums1 = {1, 3}, nums2 = {2};
		System.out.println(solution.findMedianSortedArrays(nums1, nums2));

		int[] nums3 = {1, 2}, nums4 = {3, 4};
		System.out.println(solution.findMedianSortedArrays(nums3, nums4));
	}
}
