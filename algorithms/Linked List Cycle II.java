// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

// Note: Do not modify the linked list.

// Follow up:
// Can you solve it without using extra space?

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

	/**
	 * 查找链表中环的起始点.
	 * 
	 * fast走了2k个节点, slow走了k个节点, 两点重合时:2k = k + nL (L为圈的长度) 则k = nL, 也就是,
	 * 如果k加上链表其实非重复部分的长度a, 他将到达a + nL个节点, 也就是环的起始点
	 * 
	 * @param head 链表开头
	 * @return 环的起始点
	 */
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		do {
			if (slow == null) {
				return null;
			} else {
				slow = slow.next;
			}
			if (fast != null && fast.next != null) {
				fast = fast.next.next;
			} else {
				return null;
			}
		} while (fast != slow);
		
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}