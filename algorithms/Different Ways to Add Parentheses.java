// Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


// Example 1
// Input: "2-1-1".

// ((2-1)-1) = 0
// (2-(1-1)) = 2
// Output: [0, 2]


// Example 2
// Input: "2*3-4*5"

// (2*(3-(4*5))) = -34
// ((2*3)-(4*5)) = -14
// ((2*(3-4))*5) = -10
// (2*((3-4)*5)) = -10
// (((2*3)-4)*5) = 10
// Output: [-34, -14, -10, -10, 10]

// Credits:
// Special thanks to @mithmatt for adding this problem and creating all test cases.

public class Solution {
	public List<Integer> diffWaysToCompute(String input) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
				String left = input.substring(0, i);
				String right = input.substring(i+1);
				List<Integer> leftNum = diffWaysToCompute(left);
				List<Integer> rightNum = diffWaysToCompute(right);
				for (Integer a:leftNum) {
					for (Integer b:rightNum) {
						switch (input.charAt(i)) {
						case '+':
							answer.add(a+b);
							break;
						case '-':
							answer.add(a-b);
							break;
						case '*':
							answer.add(a*b);
							break;
						}
					}
				}
			}
		}
		if (answer.size() == 0) {
			answer.add(Integer.parseInt(input));
		}
		return answer;
	}
}