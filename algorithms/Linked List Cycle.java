// Given a linked list, determine if it has a cycle in it.

// Follow up:
// Can you solve it without using extra space?
// answer: set value = null;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
		ListNode wow = new ListNode(310);
        while (head != null) {
			if (head.next == wow) {
				return true;
			}
			ListNode nextNode = head.next;
			head.next = wow;
			head = nextNode;
		}
		return false;
    }
}