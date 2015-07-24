public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
		int j = 0;
		int[] answer = {0, 0}; 
		for (i = 0; i < nums.length; i++) {
			for (j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					answer[0] = i + 1;
					answer[1] = j + 1;
					break;
				}
			}
		}
		return answer;
    }
}