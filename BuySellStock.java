/*
714. Best Time to Buy and Sell Stock with Transaction Fee
You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
Note:
    You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
    The transaction fee is only charged once for each stock purchase and sale.
*/

class BuySellStock {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        
        // Create two arrays to keep track of the maximum profit when holding a stock
        // and when not holding a stock
        int[] hold = new int[n];
        int[] notHold = new int[n];
        
        // Initialize the base cases
        hold[0] = -prices[0];
        notHold[0] = 0;
        
        // Calculate the maximum profit at each day using dynamic programming
        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], notHold[i - 1] - prices[i]);
            notHold[i] = Math.max(notHold[i - 1], hold[i - 1] + prices[i] - fee);
        }
        
        // The maximum profit will be the maximum of notHold[n - 1] and hold[n - 1]
        return Math.max(notHold[n - 1], hold[n - 1]);
    }
}