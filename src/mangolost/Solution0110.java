package mangolost;

//Given a binary tree, determine if it is height-balanced.
//
//        For this problem, a height-balanced binary tree is defined as:
//
//        a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//        Example 1:
//
//        Given the following tree [3,9,20,null,null,15,7]:
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        Return true.
//
//        Example 2:
//
//        Given the following tree [1,2,2,3,3,null,null,4,4]:
//
//        1
//        / \
//        2   2
//        / \
//        3   3
//        / \
//        4   4
//        Return false.

/**
 *
 */
public class Solution0110 {

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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth - rightDepth > 1 || rightDepth - leftDepth > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    /**
     * calculate the depth of a binary tree
     *
     * @param node
     * @return
     */
    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftDepth = getDepth(node.left);
            int rightDepth = getDepth(node.right);
            return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
        }
    }

    public static void main(String[] args) {
        Solution0110 solution = new Solution0110();
//        [1,2,2,3,3,null,null,4,4]

        //construct a binary tree
        TreeNode root = solution.new TreeNode(1);
        root.left = solution.new TreeNode(2);
        root.right = solution.new TreeNode(2);
        root.left.left = solution.new TreeNode(3);
        root.left.right = solution.new TreeNode(3);
        root.left.left.left = solution.new TreeNode(4);
        root.left.left.right = solution.new TreeNode(4);

        System.out.println(solution.isBalanced(root));
    }
}
