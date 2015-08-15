// Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

// For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.

public class Solution {
    // you need to treat n as an unsigned value
	
	//notice java右移>>是会自动为负数补1
    public int hammingWeight1(int n) {
        int answer = 0;
        for (int i = 0; i < 32; i++) {
			if ((n & 1) == 1) {
				answer++;
			}
			n = n>>1;
		}
		return answer;
    }
	
	//但是>>>三个符号的是正负都补0
    public int hammingWeight2(int n) {
        int answer = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				answer++;
			}
			n = n>>>1;
		}
		return answer;
    }
}