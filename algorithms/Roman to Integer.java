// Given a roman numeral, convert it to an integer.

// Input is guaranteed to be within the range from 1 to 3999.

public class Solution {
	// 左减的数字有限制，仅限于I、X、C
	// 但是，左减时不可跨越一个位数。
	// 左减数字必须为一位
	// from 1 to 3999.
	// I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）
	// 故仅有的减法是IV IX XL XC CD CM
	public int romanToInt(String s) {
    	int sum = 0;
    	if (s.contains("IV")) {
    		sum -= 2;
    	}
    	if (s.contains("IX")) {
    		sum -= 2;
    	}
    	if (s.contains("XL")) {
    		sum -= 20;
    	}
    	if (s.contains("XC")) {
    		sum -= 20;
    	}
    	if (s.contains("CD")) {
    		sum -= 200;
    	}
    	if (s.contains("CM")) {
    		sum -= 200;
    	}
    	
    	for (char c:s.toCharArray()) {
    		switch(c) {
    		case 'I':
    			sum += 1;
    			break;
    		case 'V':
    			sum += 5;
    			break;
    		case 'X':
    			sum += 10;
    			break;
    		case 'L':
    			sum += 50;
    			break;
    		case 'C':
    			sum += 100;
    			break;
    		case 'D':
    			sum += 500;
    			break;
    		case 'M':
    			sum += 1000;
    			break;
    		}
    	}
    	
    	return sum;
    }
}