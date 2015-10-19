// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

// For example, given the following triangle
// [
//      [2],
//     [3,4],
//    [6,5,7],
//   [4,1,8,3]
// ]
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

// Note:
// Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

public class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		for (int i = 1; i < triangle.size(); i++) {
			List<Integer> last = triangle.get(i - 1);
			List<Integer> now = triangle.get(i);
			for (int j = 0; j < now.size(); j++) {
				if (j == 0) {
					now.set(j, last.get(j) + now.get(j));
				} else if (j == now.size() - 1) {
					now.set(j, last.get(j - 1) + now.get(j));
				} else {
					int min = Math.min(last.get(j - 1), last.get(j));
					now.set(j, min + now.get(j));
				}
			}
		}

		List<Integer> underlying = triangle.get(triangle.size() - 1);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < underlying.size(); i++) {
			if (underlying.get(i) < min) {
				min = underlying.get(i);
			}
		}
		return min;
	}
}