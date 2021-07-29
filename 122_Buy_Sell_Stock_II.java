/*
@Author: Anmol Kumar Sharma

Problem: Best Time to Buy and Sell Stock II
Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

Time Complexity: O(N)
Space Complexity: O(1) 
*/

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        
        for(int i = 0; i < n-1; i++){
            if(prices[i] < prices[i+1])
                profit += Math.abs(prices[i+1] - prices[i]);
        }
        
        return profit;
    }
}
