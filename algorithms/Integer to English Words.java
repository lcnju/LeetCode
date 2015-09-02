// Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

// For example,
// 123 -> "One Hundred Twenty Three"
// 12345 -> "Twelve Thousand Three Hundred Forty Five"
// 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
// Hint:

// Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
// Group the number by thousands (3 digits). You can write a helper function that takes a number less than 1000 and convert just that chunk to words.
// There are many edge cases. What are some good test cases? Does your code work with input such as 0? Or 1000010? (middle chunk is zero and should not be printed out)

public class Solution {
	public String numberToWords(int num) {
		String[] num0_19 = { "", "One ", "Two ", "Three ", "Four ", "Five ", "Six ",
				"Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ",
				"Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ",
				"Eighteen ", "Nineteen " };
		String[] num20_90 = { "", "", "Twenty ", "Thirty ", "Forty ", "Fifty ",
				"Sixty ", "Seventy ", "Eighty ", "Ninety " };
		String hundred = "Hundred ";
		String[] num_big = { "", "Thousand ", "Million ", "Billion " };

		if (num == 0) {
			return "Zero";
		}

		int now = 0;
		int big = 0;
		String answer = "";
		while (num != 0) {
			String threeNum = "";
			now = num % 1000;
			num = num / 1000;
			if (now / 100 != 0) {
				threeNum += num0_19[now / 100] + "" + hundred + "";
			}

			now = now % 100;
			if (now < 20) {
				threeNum += num0_19[now] + "";
			} else {
				threeNum += num20_90[now / 10] + "" + num0_19[now % 10] + "";
			}

			if (!threeNum.equals("")) {
				threeNum += num_big[big] + "";				
			}
			big++;
			answer = threeNum + answer;
		}
		return answer.trim();
	}
}