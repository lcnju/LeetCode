// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

// For example,
// Given [100, 4, 200, 1, 3, 2],
// The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

// Your algorithm should run in O(n) complexity.

public class Solution {
	public int longestConsecutive(int[] nums) {
		HashMap<Integer, Integer> number = new HashMap<Integer, Integer>();
		int max = 0;
		for (int n : nums) {
			if (!number.containsKey(n)) {
				int left = number.getOrDefault(n - 1, 0);
				int right = number.getOrDefault(n + 1, 0);
				int length = left + right + 1;
				number.put(n, length);
				if (left != 0) {
					number.put(n - left, length);
				}
				if (right != 0) {
					number.put(n + right, length);
				}
				max = Math.max(max, length);
			}
		}
		return max;
	}
}