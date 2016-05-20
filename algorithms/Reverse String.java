// Write a function that takes a string as input and returns the string reversed.

// Example:
// Given s = "hello", return "olleh".

// Subscribe to see which companies asked this question

public class Solution {
    public String reverseString(String s) {
		StringBuilder answer = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			answer.append(s.charAt(i));
		}
		return answer.toString();
    }
}