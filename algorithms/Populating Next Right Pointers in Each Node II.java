// Follow up for problem "Populating Next Right Pointers in Each Node".

// What if the given tree could be any binary tree? Would your previous solution still work?

// Note:

// You may only use constant extra space.
// For example,
// Given the following binary tree,
//          1
//        /  \
//       2    3
//      / \    \
//     4   5    7
// After calling your function, the tree should look like:
//          1 -> NULL
//        /  \
//       2 -> 3 -> NULL
//      / \    \
//     4-> 5 -> 7 -> NULL

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode now = root;
		while (now != null) {
			TreeLinkNode temp = now;
			TreeLinkNode next = null;

			//寻找下一个有左右儿子的节点, 将其靠左的子树设为next
			while (temp != null) {
				temp = temp.next;
				if (temp != null && (temp.left != null || temp.right != null)) {
					break;
				}
			}
			if (temp != null && temp.left != null) {
				next = temp.left;
			} else if (temp != null && temp.right != null) {
				next = temp.right;
			}

			if (now.left != null && now.right != null) {
				now.left.next = now.right;
				now.right.next = next;
			} else if (now.left != null && now.right == null) {
				now.left.next = next;
			} else if (now.left == null && now.right != null) {
				now.right.next = next;
			}
			now = temp;
		}

		//对下一层子树中, 最左的子树进行递归
		while (root != null) {
			if (root.left != null) {
				connect(root.left);
				break;
			} else if (root.right != null) {
				connect(root.right);
				break;
			} else {
				root = root.next;
			}
		}
	}
}