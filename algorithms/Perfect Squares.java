// Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

// For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

public class Solution {
	public int numSquares(int n) {
		int[] times = new int[n + 1];
		Arrays.fill(times, Integer.MAX_VALUE);
		times[0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j * j + i < n + 1; j++) {
				times[i+j*j] = Math.min(times[i+j*j], times[i]+1);
			}
		}
		return times[n];
	}
}