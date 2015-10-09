// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
// For example,

// Consider the following matrix:
// [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
// Given target = 3, return true.

public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		int i = 0;
		for (i = 0; i < matrix.length; i++) {
			if (matrix[i][0] > target) {
				break;
			}
		}

		if (i > 0) {
			i--;
		} else {
			return false;
		}

		for (int j = 0; j < matrix[i].length; j++) {
			if (matrix[i][j] == target) {
				return true;
			}
		}

		return false;
	}
}