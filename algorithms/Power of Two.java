// Given an integer, write a function to determine if it is a power of two.

// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

public class Solution {
    public boolean isPowerOfTwo(int n) {
        while (n > 0) {
        	if ((n & 1) == 1) {
        		if (n == 1) {
        			return true;
        		} else {
        			return false;
        		}
        	}
        	n = n>>1;
        }
        return false;
    }
}