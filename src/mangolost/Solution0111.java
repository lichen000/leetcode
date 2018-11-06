package mangolost;

//Given a binary tree, find its minimum depth.
//
//        The minimum depth is the checkNumber of nodes along the shortest path from the root node down to the nearest leaf node.
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
//        return its minimum depth = 2.

/**
 *
 */
public class Solution0111 {

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
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		} else if (root.left == null) {
			return minDepth(root.right) + 1;
		} else if (root.right == null) {
			return minDepth(root.left) + 1;
		} else {
			int leftDepth = minDepth(root.left);
			int rightDepth = minDepth(root.right);
			return 1 + (leftDepth < rightDepth ? leftDepth : rightDepth);
		}
	}

	public static void main(String[] args) {
		Solution0111 solution = new Solution0111();
//        [3,9,20,null,null,15,7]

		//construct a binary tree
		TreeNode root = solution.new TreeNode(3);
		root.left = solution.new TreeNode(9);
		root.right = solution.new TreeNode(20);
		root.right.left = solution.new TreeNode(15);
		root.right.right = solution.new TreeNode(7);

		System.out.println(solution.minDepth(root));
	}
}
