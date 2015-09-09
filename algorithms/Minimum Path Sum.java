// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.

public class Solution {

	private int[][] ans;
	private int[][] gird;

	public int minPathSum(int[][] grid) {
		this.gird = grid;
		uniquePaths(gird.length, gird[0].length);
		return ans[gird.length - 1][gird[0].length - 1];
	}

	private int uniquePaths(int m, int n) {
		if (ans == null) {
			ans = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					ans[i][j] = -1;
				}
			}
			ans[0][0] = gird[0][0];
		}

		if (ans[m - 1][n - 1] == -1) {
			int left = Integer.MAX_VALUE;
			int right = Integer.MAX_VALUE;
			if (m > 1) {
				left = uniquePaths(m - 1, n);
			}
			if (n > 1) {
				right = uniquePaths(m, n - 1);
			}

			ans[m - 1][n - 1] = Math.min(left, right) + gird[m - 1][n - 1];
		}
		return ans[m - 1][n - 1];
	}
}