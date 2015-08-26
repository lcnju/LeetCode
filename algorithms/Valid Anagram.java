// Given two strings s and t, write a function to determine if t is an anagram of s.

// For example,
// s = "anagram", t = "nagaram", return true.
// s = "rat", t = "car", return false.

// Note:
// You may assume the string contains only lowercase alphabets.

public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] a_z = new int[26];
        if (s.length() != t.length()) {
        	return false;
        }
        for (int i = 0; i < s.length(); i++) {
        	a_z[s.charAt(i)-'a']++;
        	a_z[t.charAt(i)-'a']--;
        }
        for (int i = 0; i < a_z.length; i++) {
        	if (a_z[i] != 0) {
        		return false;
        	}
        }
        return true;
    }
}