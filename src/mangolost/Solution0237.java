package mangolost;

//Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
//
//        Given linked list -- head = [4,5,1,9], which looks like following:
//
//        4 -> 5 -> 1 -> 9
//        Example 1:
//
//        Input: head = [4,5,1,9], node = 5
//        Output: [4,1,9]
//        Explanation: You are given the second node with value 5, the linked list
//        should become 4 -> 1 -> 9 after calling your function.
//        Example 2:
//
//        Input: head = [4,5,1,9], node = 1
//        Output: [4,5,9]
//        Explanation: You are given the third node with value 1, the linked list
//        should become 4 -> 5 -> 9 after calling your function.
//        Note:
//
//        The linked list will have at least two elements.
//        All of the nodes' values will be unique.
//        The given node will not be the tail and it will always be a valid node of the linked list.
//        Do not return anything from your function.

/**
 *
 */
public class Solution0237 {

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
	 * @param node
	 */
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
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
		Solution0237 solution = new Solution0237();
		int[] arr = new int[]{4, 5, 1, 9};
		ListNode head = solution.genListNodes(arr);
		ListNode node = head.next.next;
		solution.deleteNode(node);
		solution.printListNodes(head);
	}
}