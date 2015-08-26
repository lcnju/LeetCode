// everse a singly linked list.

// Hint:
// A linked list can be reversed either iteratively or recursively. Could you implement both?

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode first = null;
		ListNode second = head;
		while (second != null) {
			ListNode next = second.next;
			second.next = first;
			first = second;
			second = next;
		}
		return first;
    }
}