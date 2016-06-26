// Given two arrays, write a function to compute their intersection.

// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

// Note:
// Each element in the result must be unique.
// The result can be in any order.
// Subscribe to see which companies asked this question

// Show Tags
// Show Similar Problems

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
    	HashSet<Integer> all = new HashSet<>();
    	HashSet<Integer> intersect = new HashSet<>();
    	for (int i : nums1) {
    		all.add(i);
    	}
    	for (int i : nums2) {
    		if (all.contains(i)) {
    			intersect.add(i);
    		}
    	}
    	int[] ans = new int[intersect.size()];
    	int p = 0;
    	for (Integer i : intersect) {
    		ans[p] = i;
    		p++;
    	}
    	return ans;
    }
}
