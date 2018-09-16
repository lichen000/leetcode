package mangolost;

//Find the sum of all left leaves in a given binary tree.
//
//        Example:
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//
//        There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

/**
 *
 */
public class Solution0404 {

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
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public static void main(String[] args) {
        Solution0404 solution = new Solution0404();
        TreeNode root = solution.new TreeNode(3);
        root.left = solution.new TreeNode(9);
        root.right = solution.new TreeNode(20);
        root.right.left = solution.new TreeNode(15);
        root.right.right = solution.new TreeNode(7);
        System.out.println(solution.sumOfLeftLeaves(root));
    }
}
