// Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

// For example:
// Given binary tree {3,9,20,#,#,15,7},
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its bottom-up level order traversal as:
// [
//   [15,7],
//   [9,20],
//   [3]
// ]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> answer = new ArrayList<List<Integer>>();
    	List<TreeNode> nodes = new ArrayList<TreeNode>();
    	if (root != null) {
    		nodes.add(root);
    	}
    	addItem(nodes, answer);
    	Collections.reverse(answer);
    	return answer;
    }
    
    private void addItem(List<TreeNode> nodes, List<List<Integer>> answer) {
    	
    	if(nodes.size() == 0) {
    		return;
    	}
    	
    	Iterator<TreeNode> iterator = nodes.iterator();
    	List<Integer> vals = new ArrayList<Integer>();
    	List<TreeNode> sons = new ArrayList<TreeNode>();
    	while (iterator.hasNext()) {
    		TreeNode now = iterator.next();
    		vals.add(now.val);
    		if (now.left != null) {
    			sons.add(now.left);
    		}
    		if (now.right != null) {
    			sons.add(now.right);
    		}
    	}
    	
    	answer.add(vals);
    	addItem(sons, answer);
    }
}