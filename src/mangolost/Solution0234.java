package mangolost;

//Given a singly linked list, determine if it is a palindrome.
//
//        Example 1:
//
//        Input: 1->2
//        Output: false
//        Example 2:
//
//        Input: 1->2->2->1
//        Output: true
//        Follow up:
//        Could you do it in O(n) time and O(1) space?

import java.util.Objects;

/**
 *
 */
public class Solution0234 {

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
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode last = slow.next, pre = head;
		while (Objects.requireNonNull(last).next != null) {
			ListNode tmp = last.next;
			last.next = Objects.requireNonNull(tmp).next;
			tmp.next = slow.next;
			slow.next = tmp;
		}
		while (slow.next != null) {
			slow = slow.next;
			if (pre.val != slow.val) {
				return false;
			}
			pre = pre.next;
		}
		return true;
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

	public static void main(String[] args) {
		Solution0234 solution = new Solution0234();
		int[] arr = new int[]{1, 2, 3, 4, 3, 2, 1};
		ListNode head = solution.genListNodes(arr);
		System.out.println(solution.isPalindrome(head));
	}
}