// Implement a basic calculator to evaluate a simple expression string.

// The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

// You may assume that the given expression is always valid.

// Some examples:
// "1 + 1" = 2
// " 2-1 + 2 " = 3
// "(1+(4+5+2)-3)+(6+8)" = 23
// Note: Do not use the eval built-in library function.

public class Solution {

	public int calculate(String s) {
		int a = 0;
		int b = 0;
		char ch = '*';
		for (int i = 0; i < s.length(); i++) {
			char now = s.charAt(i);
			if (now >= '0' && now <= '9') {
				if (ch == '*') {
					a *= 10;
					a += now - '0';
				} else {
					b *= 10;
					b += now - '0';
				}
			}
			if (now == '(') {
				int end = 0;
				int num = 0;
				for (int j = i; j < s.length(); j++) {
					if (s.charAt(j) == '(') {
						num++;
					}
					if (s.charAt(j) == ')') {
						num--;
					}
					if (num == 0) {
						end = j;
						break;
					}
				}
				if (ch == '*') {
					a = calculate(s.substring(i + 1, end));
				} else {
					b = calculate(s.substring(i + 1, end));
				}
				i = end;
			}
			if (now == '+' || now == '-') {
				if (ch == '*') {
					ch = now;
				} else {
					if (ch == '+') {
						a = a + b;
					} else {
						a = a - b;
					}
					b = 0;
					ch = now;
				}
			}
		}

		if (ch == '+') {
			a = a + b;
		} else if (ch == '-') {
			a = a - b;
		}
		return a;
	}
}