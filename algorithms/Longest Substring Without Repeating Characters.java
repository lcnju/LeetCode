// Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.

public class Solution {
    public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		HashMap<Character, Integer> map = new HashMap<>();
		int begin = -1;
		int next = 0;
		int answer = 0;
		while (next < s.length()) {
			Integer repeat = map.put(s.charAt(next), next);
			if (repeat != null) {
				begin = Math.max(begin, repeat);
			}
			answer = Math.max(next-begin, answer);
			next++;
		}
		return answer;
    }
}