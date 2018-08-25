package mangolost;

//Given a sorted linked list, delete all duplicates such that each element appear only once.
//
//        Example 1:
//
//        Input: 1->1->2
//        Output: 1->2
//        Example 2:
//
//        Input: 1->1->2->3->3
//        Output: 1->2->3

/**
 *
 */
public class Solution0083 {

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        ListNode next = head.next;
        while (current != null && next != null) {
            if (current.val == next.val) {
                current.next = next.next;
            } else {
                current = current.next;
            }
            next = next.next;
        }
        return head;
    }

    /**
     * @param arr
     * @return
     */
    public ListNode genListNodes(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1, len = arr.length; i < len; i++) {
            ListNode next = new ListNode(arr[i]);
            current.next = next;
            current = next;
        }
        current.next = null;
        return head;
    }

    /**
     * @param listNode
     */
    public void printListNodes(ListNode listNode) {
        ListNode current = listNode;
        if (current != null) {
            System.out.print(current.val);
            while (current.next != null) {
                System.out.print(">");
                current = current.next;
                System.out.print(current.val);
            }
            System.out.println();
        } else {
            System.out.println("空链表");
        }
    }

    public static void main(String[] args) {
        Solution0083 solution = new Solution0083();

        int[] arr = new int[]{1, 1, 2, 3, 3};
        ListNode head = solution.genListNodes(arr);

        ListNode y = solution.deleteDuplicates(head);
        solution.printListNodes(y);
    }
}
