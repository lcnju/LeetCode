// Given two arrays, write a function to compute their intersection.

// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

// Note:
// Each element in the result should appear as many times as it shows in both arrays.
// The result can be in any order.
// Follow up:
// What if the given array is already sorted? How would you optimize your algorithm?
// What if nums1's size is small compared to nums2's size? Which algorithm is better?
// What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
// Subscribe to see which companies asked this question

public class Solution {
	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> all = new HashMap<>();
		ArrayList<Integer> answer = new ArrayList<>();
		
		for (int i : nums1) {
			all.put(i, all.getOrDefault(i, 0) + 1);
		}
		
		for (int i : nums2) {
			if (all.containsKey(i) && all.get(i) > 0) {
				answer.add(i);
				all.put(i, all.get(i) - 1);
			}
		}
		
		int[] ans = new int[answer.size()];
		for (int i = 0; i < answer.size(); i++) {
			ans[i] = answer.get(i);
		}
		return ans;
	}
}