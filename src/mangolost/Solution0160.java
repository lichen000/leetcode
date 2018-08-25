package mangolost;

//Write a program to find the node at which the intersection of two singly linked lists begins.
//
//
//		For example, the following two linked lists:
//
//		A:          a1 → a2
//		↘
//		c1 → c2 → c3
//		↗
//		B:     b1 → b2 → b3
//		begin to intersect at node c1.
//
//
//		Notes:
//
//		If the two linked lists have no intersection at all, return null.
//		The linked lists must retain their original structure after the function returns.
//		You may assume there are no cycles anywhere in the entire linked structure.
//		Your code should preferably run in O(n) time and use only O(1) memory.

/**
 *
 */
public class Solution0160 {

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
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            if (a != null) {
                a = a.next;
            } else {
                a = headB;
            }
            if (b != null) {
                b = b.next;
            } else {
                b = headA;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Solution0160 solution = new Solution0160();

        ListNode headA = new ListNode(1);
        ListNode nodeA1 = new ListNode(2);

        ListNode headB = new ListNode(3);
        ListNode nodeB1 = new ListNode(4);
        ListNode nodeB2 = new ListNode(5);

        ListNode nodeC1 = new ListNode(6);
        ListNode nodeC2 = new ListNode(7);

        headA.next = nodeA1;
        nodeA1.next = nodeC1;

        headB.next = nodeB1;
        nodeB1.next = nodeB2;
        nodeB2.next = nodeC1;

        nodeC1.next = nodeC2;

        System.out.println(solution.getIntersectionNode(headA, headB).val);
    }
}