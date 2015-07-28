// Given a binary tree, return the inorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [1,3,2].

// Note: Recursive solution is trivial, could you do it iteratively?

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