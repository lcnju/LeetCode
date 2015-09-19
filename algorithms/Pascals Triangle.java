// Given numRows, generate the first numRows of Pascal's triangle.

// For example, given numRows = 5,
// Return

// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]

public class Solution {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> pascal = new ArrayList<List<Integer>>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> level = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					level.add(1);
				} else {
					level.add(pascal.get(i - 1).get(j - 1)
							+ pascal.get(i - 1).get(j));
				}
			}
			pascal.add(level);
		}
		return pascal;
	}
}