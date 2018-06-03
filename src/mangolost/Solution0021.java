package mangolost;

//Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
//
//        Example:
//
//        Input: 1->2->4, 1->3->4
//        Output: 1->1->2->3->4->4

/**
 *
 */
public class Solution0021 {

    /**
     * Definition for singly-linked list.
     *
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        if (l1.val <= l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }

    /**
     *
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
     *
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
        Solution0021 solution = new Solution0021();

        int[] arr1 = new int[]{1,2,4};
        ListNode head1 = solution.genListNodes(arr1);

        int[] arr2 = new int[]{1,3,4};
        ListNode head2 = solution.genListNodes(arr2);

        ListNode x = solution.mergeTwoLists(head1, head2);
        solution.printListNodes(x);
    }
}
