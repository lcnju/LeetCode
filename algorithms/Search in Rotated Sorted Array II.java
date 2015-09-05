// Follow up for "Search in Rotated Sorted Array":
// What if duplicates are allowed?

// Would this affect the run-time complexity? How and why?

// Write a function to determine if a given target is in the array.

public class Solution {
	public boolean search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;

		while (left < right - 1) {
			mid = (left + right) / 2;
			if (nums[mid] == target) {
				return true;
			}

			if (nums[mid] == nums[left]) {
				left++;
			} else if (nums[mid] == nums[right]) {
				right--;
			} else if (nums[mid] > nums[left]) {
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

		if (target == nums[left] || target == nums[right]) {
			return true;
		} else {
			return false;
		}
	}
}