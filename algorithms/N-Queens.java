// The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



// Given an integer n, return all distinct solutions to the n-queens puzzle.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

// For example,
// There exist two distinct solutions to the 4-queens puzzle:

// [
//  [".Q..",  // Solution 1
//   "...Q",
//   "Q...",
//   "..Q."],

//  ["..Q.",  // Solution 2
//   "Q...",
//   "...Q",
//   ".Q.."]
// ]

public class Solution {

	private ArrayList<boolean[][]> put = new ArrayList<boolean[][]>();
	private int n;
	List<List<String>> answer = new ArrayList<List<String>>();
	private int[] ans;

	public List<List<String>> solveNQueens(int n) {
		this.n = n;
		this.ans = new int[n];
		boolean[][] init = new boolean[n][n];
		put.add(init);
		putQueens(0);
		return answer;
	}

	private void putQueens(int level) {
		if (level == n) {
			addAnswer();
		} else {
			boolean[][] use = put.get(level);
			for (int i = 0; i < n; i++) {
				if (!use[level][i]) {
					boolean[][] newuse = new boolean[n][n];
					copy(use, newuse);
					changeUse(newuse, level, i);
					ans[level] = i;
					put.add(newuse);
					putQueens(level + 1);
					put.remove(level + 1);
				}
			}
		}
	}

	private void changeUse(boolean[][] use, int level, int pos) {
		for (int i = 0; i < n; i++) {
			use[i][pos] = true;
			int a = pos - (level - i);
			if (a >= 0 && a < n) {
				use[i][a] = true;
			}
			a = pos + (level - i);
			if (a >= 0 && a < n) {
				use[i][a] = true;
			}
		}
	}

	private void copy(boolean[][] use, boolean[][] newuse) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				newuse[i][j] = use[i][j];
			}
		}
	}

	private void addAnswer() {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			String s = "";
			for (int j = 0; j < n; j++) {
				if (j == ans[i]) {
					s += "Q";
				} else {
					s += ".";
				}
			}
			list.add(s);
		}
		answer.add(list);
	}
}