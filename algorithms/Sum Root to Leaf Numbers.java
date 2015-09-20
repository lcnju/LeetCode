// Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

// An example is the root-to-leaf path 1->2->3 which represents the number 123.

// Find the total sum of all root-to-leaf numbers.

// For example,

//     1
//    / \
//   2   3
// The root-to-leaf path 1->2 represents the number 12.
// The root-to-leaf path 1->3 represents the number 13.

// Return the sum = 12 + 13 = 25.

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
	public int sumNumbers(TreeNode root) {
		List<String> all = getAllNum(root);
		Iterator<String> iterator = all.iterator();
		int sum = 0;
		while (iterator.hasNext()) {
			sum += Integer.parseInt(iterator.next());
		}
		return sum;
	}

	private List<String> getAllNum(TreeNode root) {
		List<String> answer = new ArrayList<String>();
		if (root != null) {
			List<String> left = getAllNum(root.left);
			List<String> right = getAllNum(root.right);
			Iterator<String> iterator = left.iterator();
			while (iterator.hasNext()) {
				String s = root.val + "" + iterator.next();;
				answer.add(s);
			}
			iterator = right.iterator();
			while (iterator.hasNext()) {
				String s = root.val + "" + iterator.next();;
				answer.add(s);
			}
			if (answer.size() == 0) {
				answer.add(String.valueOf(root.val));
			}
		}
		return answer;
	}
}