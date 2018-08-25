package mangolost;

//Given a binary tree, return all root-to-leaf paths.
//
//        Note: A leaf is a node with no children.
//
//        Example:
//
//        Input:
//
//        1
//        /   \
//        2     3
//        \
//        5
//
//        Output: ["1->2->5", "1->3"]
//
//        Explanation: All root-to-leaf paths are: 1->2->5, 1->3

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Solution0257 {

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        if (root.left == null && root.right == null) {
            paths.add(root.val + "");
            return paths;
        }
        for (String path : binaryTreePaths(root.left)) {
            paths.add(root.val + "->" + path);
        }
        for (String path : binaryTreePaths(root.right)) {
            paths.add(root.val + "->" + path);
        }
        return paths;
    }

    public static void main(String[] args) {
        Solution0257 solution = new Solution0257();
        int[] arr = new int[]{4, 2, 7, 1, 3, 6, 9};
        TreeNode root = solution.new TreeNode(arr[0]);
        root.left = solution.new TreeNode(arr[1]);
        root.right = solution.new TreeNode(arr[2]);
        root.left.left = solution.new TreeNode(arr[3]);
        root.left.right = solution.new TreeNode(arr[4]);
        root.right.left = solution.new TreeNode(arr[5]);
        root.right.right = solution.new TreeNode(arr[6]);

        List<String> paths = solution.binaryTreePaths(root);
        for (String path : paths) {
            System.out.println(path);
        }
    }
}
