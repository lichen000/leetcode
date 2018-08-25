package mangolost;

//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
//        Note:
//
//        The number of elements initialized in nums1 and nums2 are m and n respectively.
//        You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
//        Example:
//
//        Input:
//        nums1 = [1,2,3,0,0,0], m = 3
//        nums2 = [2,5,6],       n = 3
//
//        Output: [1,2,2,3,5,6]

/**
 *
 */
public class Solution0088 {

    /**
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int currentIndex = m + n - 1;
        int index1 = m - 1;
        int index2 = n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[currentIndex] = nums2[index2];
                currentIndex--;
                index2--;
            } else if (index2 < 0) {
                nums1[currentIndex] = nums1[index1];
                currentIndex--;
                index1--;
            } else if (nums1[index1] > nums2[index2]) {
                nums1[currentIndex] = nums1[index1];
                currentIndex--;
                index1--;
            } else {
                nums1[currentIndex] = nums2[index2];
                currentIndex--;
                index2--;
            }
        }
    }

    public static void main(String[] args) {
        Solution0088 solution = new Solution0088();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0}, nums2 = new int[]{2, 5, 6};
        int m = 3, n = 3;
        solution.merge(nums1, m, nums2, n);
        System.out.print("[" + nums1[0]);
        for (int i = 1; i < m + n; i++) {
            System.out.print(", ");
            System.out.print(nums1[i]);
        }
        System.out.println("]");
    }
}
