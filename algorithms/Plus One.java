// Given a non-negative number represented as an array of digits, plus one to the number.

// The digits are stored such that the most significant digit is at the head of the list.

public class Solution {

    public int[] plusOne(int[] digits) {
    	digits[digits.length - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
        	if (digits[i] > 9) {
        		digits[i] -= 10;
        		if (i > 0) {
        			digits[i-1]++;        			
        		} else {
        			digits = createNewOne(digits);
        		}
        	}
        }
        return digits;
    }
	private int[] createNewOne(int[] digits) {
		int[] newone = new int[digits.length+1];
		newone[0] = 1;
		for (int i = 0; i < digits.length; i++) {
			newone[i+1] = digits[i];
		}
		return newone;
	}
}