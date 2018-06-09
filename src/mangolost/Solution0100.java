package mangolost;

//Given two binary trees, write a function to check if they are the same or not.
//
//        Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
//
//        Example 1:
//
//        Input:     1         1
//        / \       / \
//        2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//        Output: true
//        Example 2:
//
//        Input:     1         1
//        /           \
//        2             2
//
//        [1,2],     [1,null,2]
//
//        Output: false
//        Example 3:
//
//        Input:     1         1
//        / \       / \
//        2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//        Output: false

/**
 *
 */
public class Solution0100 {

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
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution0100 solution = new Solution0100();

        int[] arr1 = new int[]{1, 2, 4};
        TreeNode top1 = solution.new TreeNode(arr1[0]);
        top1.left = solution.new TreeNode(arr1[1]);
        top1.right = solution.new TreeNode(arr1[2]);

        int[] arr2 = new int[]{1, 2, 4};
        TreeNode top2 = solution.new TreeNode(arr2[0]);
        top2.left = solution.new TreeNode(arr2[1]);
        top2.right = solution.new TreeNode(arr2[2]);
        System.out.println(solution.isSameTree(top1, top2));
    }
}
