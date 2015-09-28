// Given an integer n, return the number of trailing zeroes in n!.

// Note: Your solution should be in logarithmic time complexity.

// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.

//100!
//5 * 10 * 15 * 20 * 25 * ... * 125
//5        5*5                  5*5*5
//计算含有不同数量的5的数字出现的次数
public class Solution {
    public int trailingZeroes(int n) {
        int zero = 0;
		//long i 因为n过大的时候会越界
        for (long i = 5; n / i > 0; i*=5) {
        	zero += n / i;
        }
        return zero;
    }
}