package mangolost;

//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
//        For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//
//        1
//        / \
//        2   2
//        / \ / \
//        3  4 4  3
//        But the following [1,2,2,null,3,null,3] is not:
//        1
//        / \
//        2   2
//        \   \
//        3    3
//        Note:
//        Bonus points if you could solve it both recursively and iteratively.

/**
 *
 */
public class Solution0101 {

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
     * @param left
     * @param right
     * @return
     */
    public boolean isSymmetricPart(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else {
            return (left.val == right.val) && isSymmetricPart(left.left, right.right) && isSymmetricPart(left.right, right.left);
        }
    }

    /**
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricPart(root.left, root.right);
    }

    public static void main(String[] args) {
        Solution0101 solution = new Solution0101();
        int[] arr = new int[]{1, 2, 2};
        TreeNode root = solution.new TreeNode(arr[0]);
        root.left = solution.new TreeNode(arr[1]);
        root.right = solution.new TreeNode(arr[2]);
        System.out.println(solution.isSymmetric(root));
    }
}
