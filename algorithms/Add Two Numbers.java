// You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
		ListNode p2 = l2;
		while (p2 != null) {
			p1.val += p2.val;
			if (p1.next == null && p2.next != null) {
				p1.next = new ListNode(0);
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		p1 = l1;
		while (p1 != null) {
			if (p1.val / 10 > 0) {
				if (p1.next == null) {
					p1.next = new ListNode(0);
				}
				p1.next.val += p1.val / 10;
				p1.val %= 10;
			}
			p1 = p1.next;
		}
		return l1;
    }
}