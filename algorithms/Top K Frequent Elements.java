// Given a non-empty array of integers, return the k most frequent elements.

// For example,
// Given [1,1,1,2,2,3] and k = 2, return [1,2].

// Note: 
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
// Subscribe to see which companies asked this question

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
public class Solution {
	public List<Integer> topKFrequent(int[] nums, int k) {
    	HashMap<Integer, Integer> statistics = new HashMap<>();
        for (int i : nums) {
        	statistics.put(i, statistics.getOrDefault(i, 0) + 1);
        }
        
        List<Entry<Integer, Integer>> order = new ArrayList<Entry<Integer, Integer>>(statistics.entrySet());
        Collections.sort(order, new Comparator<Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return -o1.getValue().compareTo(o2.getValue());
			}
		});
		
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
        	ans.add(order.get(i).getKey());
        }
        return ans;
    }
}