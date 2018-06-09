package mangolost;

//Given a binary tree, find its maximum depth.
//
//        The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//        Note: A leaf is a node with no children.
//
//        Example:
//
//        Given binary tree [3,9,20,null,null,15,7],
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        return its depth = 3.

/**
 *
 */
public class Solution0104 {

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
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
    }

    public static void main(String[] args) {
        Solution0104 solution = new Solution0104();
        int[] arr = new int[]{1, 2, 2};
        TreeNode root = solution.new TreeNode(arr[0]);
        root.left = solution.new TreeNode(arr[1]);
        root.right = solution.new TreeNode(arr[2]);
        System.out.println(solution.maxDepth(root));
    }
}
