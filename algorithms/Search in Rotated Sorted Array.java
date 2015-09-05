// Suppose a sorted array is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// You are given a target value to search. If found in the array return its index, otherwise return -1.

// You may assume no duplicate exists in the array.

public class Solution {
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		while (left < right - 1) {
			mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			}

			if (nums[mid] > nums[left]) {
				if (nums[left] <= target && target <= nums[mid]) {
					right = mid;
				} else {
					left = mid;
				}
			} else {
				if (nums[mid] <= target && target <= nums[right]) {
					left = mid;
				} else {
					right = mid;
				}
			}
		}
		if (target == nums[left]) {
			return left;
		} else if (target == nums[right]) {
			return right;
		} else {
			return -1;
		}
	}
}