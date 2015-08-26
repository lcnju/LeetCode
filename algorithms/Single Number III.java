// Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

// For example:

// Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

// Note:
// The order of the result is not important. So in the above example, [5, 3] is also correct.
// Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Solution {

	public int[] singleNumber(int[] nums) {
		HashMap<Integer, Integer> times = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (times.containsKey(nums[i])) {
				times.put(nums[i], times.get(nums[i])+1);
			} else {
				times.put(nums[i], 1);
			}
		}
		
		Iterator<Entry<Integer, Integer>> iterator = times.entrySet().iterator();
		int answerLength = 0;
		while (iterator.hasNext()) {
			Entry<Integer, Integer> entry = (Entry<Integer, Integer>) iterator.next();
			if (entry.getValue() ==1) {
				answerLength++;
			}
		}

		iterator = times.entrySet().iterator();
		int[] answer = new int[answerLength];
		int local = 0;
		while (iterator.hasNext()) {
			Entry<Integer, Integer> entry = (Entry<Integer, Integer>) iterator.next();
			if (entry.getValue() ==1) {
				answer[local] = entry.getKey();
				local++;
			}
		}
		
		return answer;
	}
}