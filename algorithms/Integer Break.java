// Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

// For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

// Note: you may assume that n is not less than 2.

// Hint:

// There is a simple O(n) solution to this problem.
// You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

public class Solution {
	public int integerBreak(int n) {
		if (n <= 3) {
			return n - 1;
		}
		switch(n % 3) {
		case 0:
			return (int) Math.round(Math.pow(3, n / 3));
		case 1:
			return (int) Math.round(Math.pow(3, n / 3 - 1)) * 4;
		case 2:
			return (int) Math.round(Math.pow(3, n / 3)) * 2;
		default:
			return 0;
		}
	}
}