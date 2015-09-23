// Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

// Calling next() will return the next smallest number in the BST.

// Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

	private LinkedList<TreeNode> list = new LinkedList<TreeNode>();

	public BSTIterator(TreeNode root) {
		if (root != null) {
			list.add(root);
			while (root.left != null) {
				list.add(root.left);
				root = root.left;
			}
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return (list.size() > 0);
	}

	/** @return the next smallest number */
	public int next() {
		if (hasNext()) {
			TreeNode smallest = list.removeLast();
			TreeNode next = smallest.right;
			while (next != null) {
				list.add(next);
				next = next.left;
			}
			return smallest.val;
		} else {
			return -1;
		}
	}
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */