// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree {3,9,20,#,#,15,7},
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        ArrayList<List<Integer>> answer = new ArrayList<List<Integer>>();
        if (root == null) {
        	return answer;
        } else {
        	nodes.add(root);
        }
        
        while (!nodes.isEmpty()) {
        	ArrayList<Integer> level = new ArrayList<Integer>();
        	ArrayList<TreeNode> nextlevel = new ArrayList<TreeNode>();
        	Iterator<TreeNode> iterator = nodes.iterator();
        	while(iterator.hasNext()) {
        		TreeNode node = iterator.next();
        		level.add(node.val);
        		if (node.left != null) {
        			nextlevel.add(node.left);
        		}
        		if (node.right != null) {
        			nextlevel.add(node.right);
        		}
        	}
        	answer.add(level);
        	nodes.clear();
        	nodes.addAll(nextlevel);
        }
        return answer;
    }
}