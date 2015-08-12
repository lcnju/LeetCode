// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

//         _______3______
//        /              \
//     ___5__          ___1__
//    /      \        /      \
//    6      _2       0       8
//          /  \
//          7   4
// For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

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
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		boolean my = false;
		boolean left = false;
		boolean right = false;
        if (root == p || root == q) {
			my = true;
		}
		TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
		if (leftNode != null) {
			left = true;
		}
		TreeNode rightNode = null;
		if (!(my && left)) {
			rightNode = lowestCommonAncestor(root.right, p, q);
		}
		if (rightNode != null) {
			right = true;
		}
		if (my && !left && !right) {
			return root;
		} else if (my && left && !right) {
			return root;
		} else if (my && !left && right) {
			return root;
		} else if (!my && left && right) {
			return root;
		} else if (!my && left && !right) {
			return leftNode;
		} else if (!my && !left && right) {
			return rightNode;
		} else {
			return null;
		}
    }
}