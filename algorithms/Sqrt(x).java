// Implement int sqrt(int x).

// Compute and return the square root of x.

public class Solution {

	public int mySqrt(int x) {
		int begin = 0;
		int end = x;
		while (begin < end) {
			long guess = (long)(begin/2.0 + 1/2.0 + end/2.0);
			long sqr = x / guess;
			if (sqr == guess) {
				return (int) guess;
			} else if (sqr > guess) {
				if (begin != guess) {
					begin = (int) guess;
				} else {
					break;
				}
			} else {
				if (end != guess) {
					end = (int) guess;
				} else {
					break;
				}
			}
		}
		return begin;
	}

}