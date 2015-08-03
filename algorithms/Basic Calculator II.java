// Implement a basic calculator to evaluate a simple expression string.

// The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

// You may assume that the given expression is always valid.

// Some examples:
// "3+2*2" = 7
// " 3/2 " = 1
// " 3+5 / 2 " = 5
// Note: Do not use the eval built-in library function.

// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.

public class Solution {
	public int calculate(String s) {
		int num[] = new int[3];
		int nums = 0;
		char ch[] = new char[2];
		int chars = 0;

		for (int i = 0; i < s.length(); i++) {
			char now = s.charAt(i);
			if (now <= '9' && now >= '0') {
				num[nums] *= 10;
				num[nums] += now - '0';
				continue;
			}
			
			if (now == ' ') {
				continue;
			}
			
			nums++;

			if (chars == 2) {
				if (ch[0] == '*') {
					num[0] = num[0] * num[1];
					num[1] = num[2];
					num[2] = 0;
					nums--;
					ch[0] = ch[1];
					chars--;
				} else if (ch[0] == '/') {
					num[0] = num[0] / num[1];
					num[1] = num[2];
					num[2] = 0;
					nums--;
					ch[0] = ch[1];
					chars--;
				} else if (ch[0] == '+' && (ch[1] == '+' || ch[1] == '-')) {
					num[0] = num[0] + num[1];
					num[1] = num[2];
					num[2] = 0;
					nums--;
					ch[0] = ch[1];
					chars--;
				} else if (ch[0] == '-' && (ch[1] == '+' || ch[1] == '-')) {
					num[0] = num[0] - num[1];
					num[1] = num[2];
					num[2] = 0;
					nums--;
					ch[0] = ch[1];
					chars--;
				} else if ((ch[0] == '+' || ch[0] == '-') && ch[1] == '*') {
					num[1] = num[1] * num[2];
					num[2] = 0;
					nums--;
					chars--;
				} else if ((ch[0] == '+' || ch[0] == '-') && ch[1] == '/') {
					num[1] = num[1] / num[2];
					num[2] = 0;
					nums--;
					chars--;
				}
			}

			ch[chars] = now;
			chars++;
		}
		
		if (chars == 2) {
			if (ch[0] == '*') {
				num[0] = num[0] * num[1];
				num[1] = num[2];
				num[2] = 0;
				nums--;
				ch[0] = ch[1];
				chars--;
			} else if (ch[0] == '/') {
				num[0] = num[0] / num[1];
				num[1] = num[2];
				num[2] = 0;
				nums--;
				ch[0] = ch[1];
				chars--;
			} else if (ch[0] == '+' && (ch[1] == '+' || ch[1] == '-')) {
				num[0] = num[0] + num[1];
				num[1] = num[2];
				num[2] = 0;
				nums--;
				ch[0] = ch[1];
				chars--;
			} else if (ch[0] == '-' && (ch[1] == '+' || ch[1] == '-')) {
				num[0] = num[0] - num[1];
				num[1] = num[2];
				num[2] = 0;
				nums--;
				ch[0] = ch[1];
				chars--;
			} else if ((ch[0] == '+' || ch[0] == '-') && ch[1] == '*') {
				num[1] = num[1] * num[2];
				num[2] = 0;
				nums--;
				chars--;
			} else if ((ch[0] == '+' || ch[0] == '-') && ch[1] == '/') {
				num[1] = num[1] / num[2];
				num[2] = 0;
				nums--;
				chars--;
			}
		}
		
		if (chars == 1) {
			switch (ch[0]) {
			case '+':
				num[0] = num[0] + num[1];
				break;
			case '-':
				num[0] = num[0] - num[1];
				break;
			case '*':
				num[0] = num[0] * num[1];
				break;
			case '/':
				num[0] = num[0] / num[1];
				break;
			}
		}
		
		return num[0];
	}
}