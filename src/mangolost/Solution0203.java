package mangolost;

//Remove all elements from a linked list of integers that have value val.
//
//        Example:
//
//        Input:  1->2->6->3->4->5->6, val = 6
//        Output: 1->2->3->4->5

/**
 *
 */
public class Solution0203 {

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

	public ListNode removeElements(ListNode head, int val) {
		while (head != null) {
			if (head.val == val) {
				head = head.next;
			} else {
				break;
			}
		}
		if (head == null) {
			return null;
		}

		ListNode cur = head;
		while (true) {
			if (cur.next == null) {
				break;
			} else {
				if (cur.next.val == val) {
					cur.next = cur.next.next;
				} else {
					cur = cur.next;
				}
			}
		}
		return head;
	}

	public static void main(String[] args) {
		Solution0203 solution = new Solution0203();

		int[] arr = new int[]{1, 2, 6, 3, 4, 5, 6};
		ListNode head = new ListNode(arr[0]);
		ListNode current = head;
		for (int i = 1, len = arr.length; i < len; i++) {
			ListNode next = new ListNode(arr[i]);
			current.next = next;
			current = next;
		}
		current.next = null;

		int val = 6;
		ListNode head2 = solution.removeElements(head, val);
		ListNode current2 = head2;
		if (current2 != null) {
			while (true) {
				System.out.print(current2.val);
				if (current2.next != null) {
					System.out.print(">");
					current2 = current2.next;
				} else {
					break;
				}
			}
			System.out.println();
		} else {
			System.out.println("空链表");
		}
	}
}
