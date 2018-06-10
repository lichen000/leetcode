package mangolost;

//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//
//        For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//        Example:
//
//        Given the sorted array: [-10,-3,0,5,9],
//
//        One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//
//        0
//        / \
//        -3   9
//        /   /
//        -10  5

/**
 *
 */
public class Solution0108 {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return sortedArrayToBSTPart(nums, 0, nums.length - 1);
    }

    /**
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private TreeNode sortedArrayToBSTPart(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTPart(nums, left, mid - 1);
        root.right = sortedArrayToBSTPart(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        Solution0108 solution = new Solution0108();
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode root = solution.sortedArrayToBST(nums);
        System.out.println(root.val);
    }
}
