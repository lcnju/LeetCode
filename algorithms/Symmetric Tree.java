// Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

// For example, this binary tree is symmetric:

//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
// But the following is not:
//     1
//    / \
//   2   2
//    \   \
//    3    3
// Note:
// Bonus points if you could solve it both recursively and iteratively.

// confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


// OJ's Binary Tree Serialization:
// The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

// Here's an example:
//    1
//   / \
//  2   3
//     /
//    4
//     \
//      5
// The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".

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
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		} else {
			return symmetric(root.left, root.right);
		}
	}

	public boolean symmetric(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null || node2 == null) {
			return false;
		}

		return (node1.val == node2.val && symmetric(node1.left, node2.right) && symmetric(
				node1.right, node2.left));
	}
}