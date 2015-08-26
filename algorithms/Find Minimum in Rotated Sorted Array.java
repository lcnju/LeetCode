// Suppose a sorted array is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// Find the minimum element.

// You may assume no duplicate exists in the array.

public class Solution {
	
	//o(logn)
	public int findMin(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.min(nums[0], nums[1]);
		}
		
		int left = 0;
		int right = nums.length - 1;
		
		if (nums[left] < nums[right]) {
			return nums[left];
		}
		
		int mid = 0;
		while (left != right - 1) {
			mid = (left + right) / 2;
			if (nums[mid] > nums[left]) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return Math.min(nums[left], nums[right]);
	}
	
	//o(n)
    public int findMinOld(int[] nums) {
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