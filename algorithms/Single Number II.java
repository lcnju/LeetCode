// Given an array of integers, every element appears three times except for one. Find that single one.

// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

public class Solution {
	public int singleNumber(int[] nums) {
		int[] each = new int[32];
		for (int i = 0; i < nums.length; i++) {
			int e = 0;
			while (nums[i] != 0) {
				each[e] += (nums[i] & 1);
				each[e] %= 3;
				e++;
				nums[i] = nums[i] >>> 1;
			}
		}
		int answer = 0;
		for (int i = each.length - 1; i >= 0; i--) {
			answer = answer << 1;
			if (each[i] != 0) {
				answer |= 1;				
			}
		}
		return answer;
	}
}