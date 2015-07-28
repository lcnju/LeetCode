// You are climbing a stair case. It takes n steps to reach to the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

public class Solution {
	public int climbStairs(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		
		int[] answer = new int[n+1];
		answer[0] = 0;
		answer[1] = 1;
		answer[2] = 2;
		for (int i = 3; i < n+1; i++) {
			answer[i] = answer[i-1] + answer[i-2];
		}
		
		return answer[n];
	}
}