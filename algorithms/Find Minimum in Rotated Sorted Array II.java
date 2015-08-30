// Follow up for "Find Minimum in Rotated Sorted Array":
// What if duplicates are allowed?

// Would this affect the run-time complexity? How and why?
// Suppose a sorted array is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// Find the minimum element.

// The array may contain duplicates.

public class Solution {
	public int findMin(int[] nums) {
    	if (nums.length == 1) {
    		return nums[0];
    	} else if (nums.length == 2) {
    		return Math.min(nums[0], nums[1]);
    	} else {
    		for (int i = 1; i < nums.length; i++) {
    			if (nums[i-1]>nums[i]) {
    				return nums[i];
    			}
    		}
    		return nums[0];    		
    	}
	}
}