// Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

// For example:
// Given n = 13,
// Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

// Hint:

// Beware of overflow.

public class Solution {
	public int countDigitOne(int n) {
		if (n / 10 == 0) {
			// 当只有1位数时, 大于等于1就出现了一次, 反之没有
			if (n >= 1) {
				return 1;
			} else {
				return 0;
			}
		} else {
			// 多位数字时,1出现的次数包括以下可能性
			// 例如321中,包括0~99,100~199,200~299,300~321
			String sNum = String.valueOf(n);
			int head = sNum.charAt(0) - '0';

			// 计算了前三个99中1的次数, 加上最后300~321中1的个数
			int answer = getOneEachSize(sNum.length() - 1) * head
					+ countDigitOne(Integer.parseInt(sNum.substring(1)));

			if (head == 1) {
				// 最高位为1时, 例如123中, 需要多加上100~123中首位重复的1
				answer += Integer.parseInt(sNum.substring(1)) + 1;
			} else {
				// 最高位不是1时, 需要加上100~199中最高位出现的100次1
				answer += Math.pow(10, sNum.length() - 1);
			}
			return answer;
		}
	}

	/**
	 * 获取当前位数,1~9,99,999所有1的次数. 1~9 1 1~99 20 1~999 300 1~9999 4000
	 * 
	 * @param n 9的数量
	 * @return 1 出现的次数
	 */
	private int getOneEachSize(int n) {
		return (int) Math.pow(10, n - 1) * n;
	}
}