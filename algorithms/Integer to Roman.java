// Given an integer, convert it to a roman numeral.

// Input is guaranteed to be within the range from 1 to 3999.

public class Solution {
	public String intToRoman(int num) {
		int[] intList = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] romanList = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		String answer = "";
		while (num > 0) {
			for (int i = 0; i < intList.length; i++) {
				if (intList[i] <= num) {
					num -= intList[i];
					answer += romanList[i];
					break;
				}
			}
		}
		return answer;
	}
}