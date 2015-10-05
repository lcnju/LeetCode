// Given an index k, return the kth row of the Pascal's triangle.

// For example, given k = 3,
// Return [1,3,3,1].

// Note:
// Could you optimize your algorithm to use only O(k) extra space?

public class Solution {
	public List<Integer> getRow(int rowIndex) {
		int row = 0;
		ArrayList<Integer> uplevel = new ArrayList<Integer>();
		ArrayList<Integer> nowlevel = new ArrayList<Integer>();
		while (row <= rowIndex) {
			uplevel.clear();
			uplevel.addAll(nowlevel);
			nowlevel.clear();
			for (int i = 0; i <= row; i++) {
				if (i == 0 || i == row) {
					nowlevel.add(1);
				} else {
					nowlevel.add(uplevel.get(i - 1) + uplevel.get(i));
				}
			}
			row++;
		}
		return nowlevel;
	}
}