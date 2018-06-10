package mangolost;

//Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
//
//        Note: A leaf is a node with no children.
//
//        Example:
//
//        Given the below binary tree and sum = 22,
//
//        5
//        / \
//        4   8
//        /   / \
//        11  13  4
//        /  \      \
//        7    2      1
//        return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

/**
 *
 */
public class Solution0112 {

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
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            return root.val == sum;
        } else {
            int sumx = sum - root.val;
            return hasPathSum(root.left, sumx) || hasPathSum(root.right, sumx);
        }
    }

    public static void main(String[] args) {
        Solution0112 solution = new Solution0112();
//        [3,9,20,null,null,15,7]

        //construct a binary tree
        TreeNode root = solution.new TreeNode(5);
        root.left = solution.new TreeNode(4);
        root.right = solution.new TreeNode(8);
        root.left.left = solution.new TreeNode(11);
        root.right.left = solution.new TreeNode(13);
        root.right.right = solution.new TreeNode(4);
        root.left.left.left = solution.new TreeNode(7);
        root.left.left.right = solution.new TreeNode(2);
        root.right.right.right = solution.new TreeNode(1);

        int sum = 22;
        System.out.println(solution.hasPathSum(root, sum));
    }
}
