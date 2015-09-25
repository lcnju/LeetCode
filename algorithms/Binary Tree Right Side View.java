// Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

// For example:
// Given the following binary tree,
//    1            <---
//  /   \
// 2     3         <---
//  \     \
//   5     4       <---
// You should return [1, 3, 4].

// Credits:
// Special thanks to @amrsaqr for adding this problem and creating all test cases.

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
    public List<Integer> rightSideView(TreeNode root) {
    	LinkedList<LinkedList<Integer>> level = levelOrder(root);
    	ArrayList<Integer> right = new ArrayList<Integer>();
    	for (int i = 0; i < level.size(); i++) {
    		right.add(level.get(i).getLast());
    	}
    	return right;
    }
    
    private LinkedList<LinkedList<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<LinkedList<Integer>> answer = new LinkedList<LinkedList<Integer>>();
        if (root == null) {
        	return answer;
        } else {
        	nodes.add(root);
        }
        
        while (!nodes.isEmpty()) {
        	LinkedList<Integer> level = new LinkedList<Integer>();
        	LinkedList<TreeNode> nextlevel = new LinkedList<TreeNode>();
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