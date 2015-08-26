// Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You may assume no duplicates in the array.

// Here are few examples.
// [1,3,5,6], 5 → 2
// [1,3,5,6], 2 → 1
// [1,3,5,6], 7 → 4
// [1,3,5,6], 0 → 0

public class Solution {
	//array
	public int searchInsert(int[] nums, int target) {
	    int i;
		for (i = 0; i < nums.length; i++) {
			if (nums[i] >= target) {
				return i;
			}
		}
		return i;
	}
	
	//Binary Search
	public int searchInsert(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int mid = 0;
		while (high > low) {
			mid = (low + high) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		if (nums[low] < target) {
			return low + 1;
		}
		return low;
	}
}