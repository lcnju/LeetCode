// Say you have an array for which the ith element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

public class Solution {
    public int maxProfit(int[] prices) {
        int mix = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 0; i < prices.length; i++) {
        	if (prices[i] < mix) {
        		mix = prices[i];
        	} else {
        		answer = Math.max(answer, prices[i] - mix);
        	}
        }
        return answer;
    }
}