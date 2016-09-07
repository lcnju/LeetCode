// Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

// Examples:

// s = "leetcode"
// return 0.

// s = "loveleetcode",
// return 2.

public class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hashMap.containsKey(ch)) {
                hashMap.put(ch, -1);
            } else {
                hashMap.put(ch, i);
            }
        }
        Iterator<Map.Entry<Character, Integer>> iterator = hashMap.entrySet().iterator();
        int index = Integer.MAX_VALUE;
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            if (entry.getValue() != -1 && entry.getValue() < index) {
                index = entry.getValue();
            }
        }
        if (index == Integer.MAX_VALUE) {
            return -1;
        } else {
            return index;
        }
    }
}