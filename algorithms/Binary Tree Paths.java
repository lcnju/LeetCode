// Given a binary tree, return all root-to-leaf paths.

// For example, given the following binary tree:

//    1
//  /   \
// 2     3
//  \
//   5
// All root-to-leaf paths are:

// ["1->2->5", "1->3"]
// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> son = new ArrayList<String>();
        List<String> answer = new ArrayList<String>();
        
        if (root == null) {
        	return answer;
        }
        
        son.addAll(binaryTreePaths(root.left));
        son.addAll(binaryTreePaths(root.right));
        
        if (son.size() == 0) {
        	answer.add(String.valueOf(root.val));
        } else {
        	Iterator<String> iterator = son.iterator();
        	while (iterator.hasNext()) {
        		String path = iterator.next();
        		answer.add(root.val + "->" + path);
        	}
        }
        
        return answer;
    }
}