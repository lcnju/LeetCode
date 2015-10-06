// Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

// For example:
// Given the below binary tree and sum = 22,
//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \      \
//         7    2      1
// return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

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
    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
        	return false;
        } else {
        	stack.push(root);        	
        }
        
        while (!stack.isEmpty()) {
        	TreeNode node = stack.pop();
        	if (node.left == null && node.right == null && node.val == sum) {
        		return true;
        	} else {
        		if (node.left != null) {
        			node.left.val += node.val;
        			stack.push(node.left);
        		}
        		if (node.right != null) {
        			node.right.val += node.val;
        			stack.push(node.right);
        		}
        	}
        }
        
        return false;
    }
}