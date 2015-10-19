// Given a pattern and a string str, find if str follows the same pattern.

// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

// Examples:
// pattern = "abba", str = "dog cat cat dog" should return true.
// pattern = "abba", str = "dog cat cat fish" should return false.
// pattern = "aaaa", str = "dog cat cat dog" should return false.
// pattern = "abba", str = "dog dog dog dog" should return false.
// Notes:
// You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

// Credits:
// Special thanks to @minglotus6 for adding this problem and creating all test cases.

public class Solution {
	public boolean wordPattern(String pattern, String str) {
		HashMap<String, Character> map = new HashMap<String, Character>();
		String[] words = str.split(" ");
		int i = 0;
		for (i = 0; i < words.length; i++) {
			if (i >= pattern.length()) {
				return false;
			}
			if (map.containsKey(words[i])) {
				if (!map.get(words[i]).equals(pattern.charAt(i))) {
					return false;
				}
			} else {
				if (map.containsValue(pattern.charAt(i))) {
					return false;
				} else {
					map.put(words[i], pattern.charAt(i));
				}
			}
		}
		if (i < pattern.length()) {
			return false;
		}
		return true;
	}
}