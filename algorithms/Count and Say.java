// The count-and-say sequence is the sequence of integers beginning as follows:
// 1, 11, 21, 1211, 111221, ...

// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// Given an integer n, generate the nth sequence.

// Note: The sequence of integers will be represented as a string.

public class Solution {
	public String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}
		String answer = "";
		String num = countAndSay(n - 1);

		if (num.length() == 1) {
			return "1" + num;
		}

		int times = 1;
		for (int i = 1; i < num.length(); i++) {
			if (num.charAt(i - 1) == num.charAt(i)) {
				times++;
			} else {
				answer += times + "" + num.charAt(i - 1);
				times = 1;
			}
		}
		if (times != 0) {
			answer += times + "" + num.charAt(num.length() - 1);
		}

		return answer;
	}
}