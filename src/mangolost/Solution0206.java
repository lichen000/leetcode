package mangolost;

//Reverse a singly linked list.
//
//		Example:
//
//		Input: 1->2->3->4->5->NULL
//		Output: 5->4->3->2->1->NULL
//		Follow up:
//
//		A linked list can be reversed either iteratively or recursively. Could you implement both?

/**
 *
 */
public class Solution0206 {

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
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode nextNode = head.next;
		ListNode headNew = reverseList(head.next); //在这个递归中会改变nextNode指向，最后指向最后末位
		nextNode.next = head;
		head.next = null;
		return headNew;
	}

	/**
	 *
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
	 *
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
		Solution0206 solution = new Solution0206();

		int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
		ListNode head = solution.genListNodes(arr);

		ListNode headNew = solution.reverseList(head);

		solution.printListNodes(headNew);
	}
}
