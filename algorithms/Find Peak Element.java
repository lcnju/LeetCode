// A peak element is an element that is greater than its neighbors.

// Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

// The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

// You may imagine that num[-1] = num[n] = -∞.

// For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

// click to show spoilers.

// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.

public class Solution {
	public int findPeakElement(int[] nums) {
		int begin = 0;
		int end = nums.length - 1;
		int mid1 = 0;
		int mid2 = 0;
		while (end - begin > 0) {
			mid1 = (end + begin) / 2;
			mid2 = mid1 + 1;
			if (nums[mid1] > nums[mid2]) {
				end = mid1;
			} else {
				begin = mid2;
			}
		}
		return begin;
	}
}