// Follow up for N-Queens problem.

// Now, instead outputting board configurations, return the total number of distinct solutions.

public class Solution {

	private ArrayList<boolean[][]> put = new ArrayList<boolean[][]>();
	private int answer;
	private int n;

	public int totalNQueens(int n) {
		this.n = n;
		boolean[][] init = new boolean[n][n];
		put.add(init);
		putQueens(0);
		return answer;
	}

	private void putQueens(int level) {
		if (level == n) {
			answer++;
		} else {
			boolean[][] use = put.get(level);
			for (int i = 0; i < n; i++) {
				if (!use[level][i]) {
					boolean[][] newuse = new boolean[n][n];
					copy(use, newuse);
					changeUse(newuse, level, i);
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
}