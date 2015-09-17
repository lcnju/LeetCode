// Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

// Note: 
// You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

// Follow up:
// What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

// Hint:
// Try to utilize the property of a BST.
// What if you could modify the BST node's structure?
// The optimal runtime complexity is O(height of BST).

// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.

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
	public int kthSmallest(TreeNode root, int k) {
		List<Integer> inorder = inorderTraversal(root);
		return inorder.get(k - 1);
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> answer = new ArrayList<>();
		if (root == null) {
			return answer;
		}
		if (root.left != null) {
			answer.addAll(inorderTraversal(root.left));
		}
		answer.add(root.val);
		if (root.right != null) {
			answer.addAll(inorderTraversal(root.right));
		}
		return answer;
	}
}