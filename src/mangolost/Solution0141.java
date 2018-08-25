package mangolost;

//Given a linked list, determine if it has a cycle in it.
//
//		Follow up:
//		Can you solve it without using extra space?

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class Solution0141 {

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)) {
                return true;
            } else {
                visited.add(head);
                head = head.next;
            }
        }
        return false;
    }

    /**
     * @param arr
     * @return
     */
    private ListNode genListNodes(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1, len = arr.length; i < len; i++) {
            ListNode next = new ListNode(arr[i]);
            current.next = next;
            current = next;
        }
        if (current.val == 999) {
            current.next = head;
        } else {
            current.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution0141 solution = new Solution0141();

        int[] arr1 = new int[]{1, 2, 4};
        ListNode head1 = solution.genListNodes(arr1);

        int[] arr2 = new int[]{1, 3, 4, 999};
        ListNode head2 = solution.genListNodes(arr2);

        System.out.println(solution.hasCycle(head1));
        System.out.println(solution.hasCycle(head2));

    }
}
