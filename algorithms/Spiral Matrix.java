// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

// For example,
// Given the following matrix:

// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// You should return [1,2,3,6,9,8,7,4,5].

public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> lists = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return lists;
        }
		// up 1
		// right 2
		// down 3
		// left 4
		int face = 2;
		int i = 0;
		int j = 0;
		int n = 0;

		while (lists.size() < matrix[0].length * matrix.length) {
			lists.add(matrix[i][j]);
			matrix[i][j] = Integer.MAX_VALUE;
			switch (face) {
			case 1:
				if (i - 1 >= 0 && matrix[i - 1][j] != Integer.MAX_VALUE) {
					i--;
				} else {
					face = 2;
					j++;
				}
				break;
			case 2:
				if (j + 1 < matrix[0].length
						&& matrix[i][j + 1] != Integer.MAX_VALUE) {
					j++;
				} else {
					face = 3;
					i++;
				}
				break;
			case 3:
				if (i + 1 < matrix.length
						&& matrix[i + 1][j] != Integer.MAX_VALUE) {
					i++;
				} else {
					face = 4;
					j--;
				}
				break;
			case 4:
				if (j - 1 >= 0 && matrix[i][j - 1] != Integer.MAX_VALUE) {
					j--;
				} else {
					face = 1;
					i--;
				}
			}
		}

		return lists;
	}
}