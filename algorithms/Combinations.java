// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

// For example,
// If n = 4 and k = 2, a solution is:

// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]

public class Solution {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> answer = new ArrayList<List<Integer>>();

		if (n == 1) {
			ArrayList<Integer> one = new ArrayList<Integer>();
			if (k == 1) {
				one.add(1);
			}

			answer.add(one);
			return answer;
		}

		if (n > k) {
			List<List<Integer>> hasnotMe = combine(n - 1, k);
			answer.addAll(hasnotMe);
		}

		if (k > 0) {
			List<List<Integer>> hasMe = combine(n - 1, k - 1);
			Iterator<List<Integer>> iterator = hasMe.iterator();
			while (iterator.hasNext()) {
				iterator.next().add(n);
			}
			answer.addAll(hasMe);
		}
		return answer;
	}
}