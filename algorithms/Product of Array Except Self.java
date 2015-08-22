// Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

// Solve it without division and in O(n).

// For example, given [1,2,3,4], return [24,12,8,6].

// Follow up:
// Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

public class Solution {
	public int[] productExceptSelf(int[] nums) {
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		int[] answer = new int[nums.length];
		left[0] = nums[0];
		right[nums.length - 1] = nums[nums.length - 1];
		for (int i = 1; i < nums.length - 1; i++) {
			left[i] = left[i - 1] * nums[i];
			right[nums.length - i - 1] = right[nums.length - i]
					* nums[nums.length - i - 1];
		}
		for (int i = 0; i < nums.length; i++) {
			answer[i] = 1;
			if (i != 0) {
				answer[i] *= left[i - 1];
			}
			if (i != nums.length - 1) {
				answer[i] *= right[i + 1];
			}
		}
		return answer;
	}
}