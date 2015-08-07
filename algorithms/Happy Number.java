// Write an algorithm to determine if a number is "happy".

// A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

// Example: 19 is a happy number

// 12 + 92 = 82
// 82 + 22 = 68
// 62 + 82 = 100
// 12 + 02 + 02 = 1
// Credits:
// Special thanks to @mithmatt and @ts for adding this problem and creating all test cases.

public class Solution {

	public boolean isHappy(int n) {
		HashSet<Integer> answer = new HashSet<>();
        while (n != 1) {
        	if (answer.contains(n)) {
        		return false;
        	} else {
        		answer.add(n);
        	}
        	n = check(n);
        }
        return true;
    }
	
	private int check(int num) {
        int[] squares = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81};
        int sum = 0;
        int a = 0;
		while (num > 0) {
			a = num % 10;
			num = num / 10;
			sum += squares[a];
		}
		return sum;
	}
}