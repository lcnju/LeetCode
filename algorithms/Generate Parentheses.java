// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:

// "((()))", "(()())", "(())()", "()(())", "()()()"

public class Solution {
	private List<String> strings = new ArrayList<String>();

	public List<String> generateParenthesis(int n) {
		repeat(0, 0, n, "");
		return strings;
	}

	private void repeat(int left,int right, int n, String s) {
		if (left < n) {
			if (left == right) {
				repeat(left+1, right, n, s+"(");
			} else {
				repeat(left+1, right, n, s+"(");
				repeat(left, right+1, n, s+")");
			}
		} else if (right < n) {
			if (left != right) {
				repeat(left, right+1, n, s+")");
			}
		} else {
			strings.add(s);
		}
    }
}