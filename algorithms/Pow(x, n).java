// Implement pow(x, n).

public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
        	return 1;
        } else if (n == 1) {
        	return x;
        } else {
        	boolean fu = n < 0;
        	if (fu) {
        		n = -n;
        	}
        	double answer = myPow(x, n/2);
        	answer = answer * answer;
        	if (n % 2 == 1) {
        		answer *= x;
        	}
        	answer = (fu)?1.0/answer:answer;
        	return answer;
        }
    }
}