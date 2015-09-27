// Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        int[] nums = new int[length];
        p = head;
        int i = 0;
        while (p != null) {
            nums[i] = p.val;
            i++;
            p = p.next;
        }
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int begin, int length) {
        if (length <= 0) {
            return null;
        }
        int mid = begin + length / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, begin, mid - begin);
        root.right = sortedArrayToBST(nums, mid + 1, length - mid + begin - 1);
        return root;
    }
}