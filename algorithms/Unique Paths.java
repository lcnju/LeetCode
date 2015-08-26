// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

// How many possible unique paths are there?

public class Solution {
	private int[][] ans = null;

	public int uniquePaths(int m, int n) {
		if (ans == null) {
			ans = new int[m][n];
			ans[0][0] = 1;
		}

		if (ans[m - 1][n - 1] == 0) {
			int answer = 0;
			if (m > 1) {
				answer += uniquePaths(m - 1, n);
			}
			if (n > 1) {
				answer += uniquePaths(m, n - 1);
			}
			ans[m - 1][n - 1] = answer;
		}
		return ans[m - 1][n - 1];
	}
}