// Follow up for "Remove Duplicates":
// What if duplicates are allowed at most twice?

// For example,
// Given sorted array nums = [1,1,1,2,2,3],

// Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

public class Solution {
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 2) {
			return nums.length;
		}

		int length = 0;
		for (int i = 0; i < nums.length-2; i++) {
			if (nums[i] == nums[i+2]) {
				nums[i] = Integer.MAX_VALUE;
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != Integer.MAX_VALUE) {
				nums[length] = nums[i];
				length++;
			}
		}
		return length;
	}
}