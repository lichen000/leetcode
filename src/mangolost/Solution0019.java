package mangolost;

/**
 *
 */
public class Solution0019 {

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
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = dummy;
		ListNode second = dummy;
		for (int i = 1; i <= n + 1; i++) {
			first = first.next;
		}
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummy.next;
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
		Solution0019 solution = new Solution0019();
		int[] arr = new int[]{1, 9, 9, 3, 0, 7, 1, 6};
		ListNode head = solution.genListNodes(arr);
		ListNode x = solution.removeNthFromEnd(head, 4);
		solution.printListNodes(x);
	}
}
