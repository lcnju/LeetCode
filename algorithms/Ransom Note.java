// Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom  note can be constructed from the magazines ; otherwise, it will return false. 

// Each letter in the magazine string can only be used once in your ransom note.

// Note:
// You may assume that both strings contain only lowercase letters.

// canConstruct("a", "b") -> false
// canConstruct("aa", "ab") -> false
// canConstruct("aa", "aab") -> true

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] times = new int[1024];
        for (int i = 0; i < magazine.length(); i++) {
            times[magazine.charAt(i)]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (times[ransomNote.charAt(i)] > 0) {
                times[ransomNote.charAt(i)]--;
            } else {
                return false;
            }
        }
        return true;
    }
}