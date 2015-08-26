// Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

// For example,
// Given n = 3, there are a total of 5 unique BST's.

public class Solution {
	public int[] cache = null;
    public int numTrees(int n) {
    	if (cache == null) {
    		cache = new int[n+1];
    	}
    	
    	if (cache[n] != 0) {
    		return cache[n];
    	}
    	
    	if (n == 0) {
    		return 1;
    	}
        if (n == 1) {
        	return 1;
        }
        if (n == 2) {
        	return 2;
        }
        
        int num = 0;
        for (int i = 0; i < n; i++) {
        	num += numTrees(i) * numTrees(n-1-i);
        }
        cache[n] = num;
        return num;
    }
}