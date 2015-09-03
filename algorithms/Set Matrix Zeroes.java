// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

// click to show follow up.

// Follow up:
// Did you use extra space?
// A straight forward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?

public class Solution {
	//o(m*n) space
	public void setZeroes(int[][] matrix) {
		boolean[] iZero = new boolean[matrix.length];
		boolean[] jZero = new boolean[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					iZero[i] = true;
					jZero[j] = true;
				}
			}
		}
		
		for (int i = 0; i < matrix.length; i++) {
			if (iZero[i]) {
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		
		for (int j = 0; j < matrix[0].length; j++) {
			if (jZero[j]) {
				for (int i = 0; i < matrix.length; i++) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}