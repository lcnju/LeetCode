// Given a binary tree, return the postorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [3,2,1].

// Note: Recursive solution is trivial, could you do it iteratively?

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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> answer = new ArrayList<>();
		if (root == null) {
			return answer;
		}
		if (root.left != null) {
			answer.addAll(postorderTraversal(root.left));
		}
		if (root.right != null) {
			answer.addAll(postorderTraversal(root.right));
		}
		answer.add(root.val);
		return answer;
    }
}