package mangolost;

//Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//
//        For example:
//        Given binary tree [3,9,20,null,null,15,7],
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        return its bottom-up level order traversal as:
//        [
//        [15,7],
//        [9,20],
//        [3]
//        ]


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 */
public class Solution0107 {

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
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (true) {
			Queue<TreeNode> temp = new LinkedList<>();
			List<Integer> tempList = new ArrayList<>();
			while (!queue.isEmpty()) {
				TreeNode t = queue.poll();
				if (t != null) {
					tempList.add(t.val);
					if (t.left != null) {
						temp.add(t.left);
					}
					if (t.right != null) {
						temp.add(t.right);
					}
				}
			}
			list.add(0, tempList);
			if (temp.isEmpty()) {
				break;
			}
			queue = temp;
		}
		return list;
	}

	public static void main(String[] args) {
		Solution0107 solution = new Solution0107();
		TreeNode root = solution.new TreeNode(3);
		root.left = solution.new TreeNode(9);
		root.right = solution.new TreeNode(20);
		root.right.left = solution.new TreeNode(15);
		root.right.right = solution.new TreeNode(7);
		List<List<Integer>> list = solution.levelOrderBottom(root);
		System.out.println("OK");
	}
}
