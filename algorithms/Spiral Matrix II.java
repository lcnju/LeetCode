// Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

// For example,
// Given n = 3,

// You should return the following matrix:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]

public class Solution {
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];

		// up 1
		// right 2
		// down 3
		// left 4
		int face = 2;
		int i = 0;
		int j = 0;
		int x = 1;

		while (x <= n*n) {
			matrix[i][j] = x;
			x++;
			switch (face) {
			case 1:
				if (i - 1 >= 0 && matrix[i - 1][j] == 0) {
					i--;
				} else {
					face = 2;
					j++;
				}
				break;
			case 2:
				if (j + 1 < matrix[0].length
						&& matrix[i][j + 1] ==0) {
					j++;
				} else {
					face = 3;
					i++;
				}
				break;
			case 3:
				if (i + 1 < matrix.length
						&& matrix[i + 1][j] ==0) {
					i++;
				} else {
					face = 4;
					j--;
				}
				break;
			case 4:
				if (j - 1 >= 0 && matrix[i][j - 1] ==0) {
					j--;
				} else {
					face = 1;
					i--;
				}
			}
		}

		return matrix;
	}
}