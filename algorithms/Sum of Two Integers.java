// Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

// Example:
// Given a = 1 and b = 2, return 3.

// Credits:
// Special thanks to @fujiaozhu for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

public class Solution {
    public int getSum(int a, int b) {
        if (b == 0) {
        	return a;
        } else {
        	return getSum(a^b, (a&b)<<1);
        }
    }
}