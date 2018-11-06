package mangolost;

//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//		You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//		Example:
//
//		Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//		Output: 7 -> 0 -> 8
//		Explanation: 342 + 465 = 807.

/**
 *
 */
public class Solution0002 {

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
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, current = dummyHead;
		int temp = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = temp + x + y;
			temp = sum / 10;
			current.next = new ListNode(sum % 10);
			current = current.next;
			if (p != null) {
				p = p.next;
			}
			if (q != null) {
				q = q.next;
			}
		}
		if (temp > 0) {
			current.next = new ListNode(temp);
		}
		return dummyHead.next;
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
		current.next = null;
		return head;
	}

	/**
	 * @param listNode
	 */
	private void printListNodes(ListNode listNode) {
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
		Solution0002 solution = new Solution0002();
		int[] arr1 = new int[]{1, 9, 9, 3, 0, 7, 1, 6};
		ListNode head1 = solution.genListNodes(arr1);
		int[] arr2 = new int[]{1, 9, 8, 7, 0, 7, 1, 5};
		ListNode head2 = solution.genListNodes(arr2);
		ListNode x = solution.addTwoNumbers(head1, head2);
		solution.printListNodes(x);
	}
}
