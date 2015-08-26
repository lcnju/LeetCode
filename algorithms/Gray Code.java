// The gray code is a binary numeral system where two successive values differ in only one bit.

// Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

// For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

// 00 - 0
// 01 - 1
// 11 - 3
// 10 - 2
// Note:
// For a given n, a gray code sequence is not uniquely defined.

// For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

// For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.

// 格雷码 二进制首位加0 按位异或

public class Solution {
	
	//best
	public List<Integer> bestGrayCode(int n) {
		List<Integer> result = new LinkedList<Integer>();
		for (int i = 0; i < 1 << n; i++) {
			result.add(i ^ i >> 1);
		}
		return result;
	}
	
	//too long
	public List<Integer> grayCode(int n) {
		List<Integer> answer = new ArrayList<Integer>();
		for (int i = 0; i < Math.pow(2, n); i++) {
			String temp = "0" + intToString(i, n);
			String b = "";
			for (int j = 0; j < temp.length() - 1; j++) {
				if (temp.charAt(j) == temp.charAt(j + 1)) {
					b += "0";
				} else {
					b += "1";
				}
			}
			answer.add(stringToInt(b));
		}

		return answer;
	}

	private String intToString(int i, int n) {
		String answer = Integer.toBinaryString(i);
		while (answer.length() < n) {
			answer = "0" + answer;
		}
		return answer;
	}

	private int stringToInt(String s) {
		int answer = 0;
		for (int i = 0; i < s.length(); i++) {
			answer = answer << 1;
			if (s.charAt(i) == '1') {
				answer += 1;
			}
		}
		return answer;
	}

}