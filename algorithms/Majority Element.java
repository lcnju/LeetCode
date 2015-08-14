// Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

// You may assume that the array is non-empty and the majority element always exist in the array.

// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.

//Leetcode do not import Entry, use Map.Entry
public class Solution {
	public int majorityElement(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
			if (map.get(nums[i]) > nums.length / 2) {
				return nums[i];
			}
		}
		Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
		int maxValue = 0;
		int maxKey = 0;
		while (iter.hasNext()) {
			Map.Entry<Integer, Integer> entry = iter.next();
			if (entry.getValue() > maxValue) {
				maxValue = entry.getValue();
				maxKey = entry.getKey();
			}
		}
		return maxKey;
	}
}