// Given a binary tree, determine if it is height-balanced.

// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

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

    public boolean isBalanced(TreeNode root) {
        return getResult(root).isBalanced;
    }
    
    private class Result {
    	public int deep;
    	public boolean isBalanced;
    }
    
    private Result getResult(TreeNode root) {
    	Result result = new Result();
    	if (root == null) {
    		result.deep = 0;
    		result.isBalanced = true;
    		return result;
    	}
    	
    	Result left = getResult(root.left);
    	Result right = getResult(root.right);
    	
    	if (!left.isBalanced || !right.isBalanced) {
    		result.isBalanced = false;
    		return result;
    	}
    	
    	if (Math.abs(left.deep - right.deep) > 1) {
    		result.isBalanced = false;
    		return result;
    	} else {
    		result.deep = Math.max(left.deep, right.deep) + 1;
    		result.isBalanced = true;
    		return result;
    	}
    }
}