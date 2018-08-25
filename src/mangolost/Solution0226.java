package mangolost;

//Invert a binary tree.
//
//        Example:
//
//        Input:
//
//        4
//        /   \
//        2     7
//        / \   / \
//        1   3 6   9
//        Output:
//
//        4
//        /   \
//        7     2
//        / \   / \
//        9   6 3   1

/**
 *
 */
public class Solution0226 {

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
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            invertTree(root.left);
            invertTree(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }

    public static void main(String[] args) {
        Solution0226 solution = new Solution0226();
        int[] arr = new int[]{4, 2, 7, 1, 3, 6, 9};
        TreeNode root = solution.new TreeNode(arr[0]);
        root.left = solution.new TreeNode(arr[1]);
        root.right = solution.new TreeNode(arr[2]);
        root.left.left = solution.new TreeNode(arr[3]);
        root.left.right = solution.new TreeNode(arr[4]);
        root.right.left = solution.new TreeNode(arr[5]);
        root.right.right = solution.new TreeNode(arr[6]);

        TreeNode root2 = solution.invertTree(root);
        System.out.println(root2.left.left.val);
    }
}
