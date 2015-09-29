// Given a binary tree, flatten it to a linked list in-place.

// For example,
// Given

//          1
//         / \
//        2   5
//       / \   \
//      3   4   6
// The flattened tree should look like:
//    1
//     \
//      2
//       \
//        3
//         \
//          4
//           \
//            5
//             \
//              6
// click to show hints.

// Hints:
// If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

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
    public void flatten(TreeNode root) {
        List<TreeNode> nodes = inorderTraversal(root);
        for (int i = 0; i < nodes.size() - 1; i++) {
        	TreeNode now = nodes.get(i);
        	TreeNode next = nodes.get(i+1);
        	now.left = null;
        	now.right = next;
        }
    }
    
    private List<TreeNode> inorderTraversal(TreeNode root) {
        ArrayList<TreeNode> answer = new ArrayList<>();
		if (root == null) {
			return answer;
		}
		answer.add(root);
		if (root.left != null) {
			answer.addAll(inorderTraversal(root.left));
		}
		if (root.right != null) {
			answer.addAll(inorderTraversal(root.right));
		}
		return answer;
    }
}