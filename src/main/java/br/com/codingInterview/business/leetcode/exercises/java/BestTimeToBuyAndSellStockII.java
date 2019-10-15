/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.Stack;

/**
 * @author Evaristo
 * 
 * 122. Best Time to Buy and Sell Stock II
 *
 */
public class BestTimeToBuyAndSellStockII {

	/**
	 * 
	 * 
	 * 
	 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
	 */
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockII b = new BestTimeToBuyAndSellStockII();
		int[] prices = {1,2,3,4,5};
		System.out.println(b.maxProfit2(prices));

	}
	
    public int maxProfit(int[] prices) {
        int maxValue = 0;
        Stack<Integer> buy = new Stack<Integer>();
        Stack<Integer> sell = new Stack<Integer>(); 
        
        for(int i = 0; i < prices.length; i++) {
        	if(buy.isEmpty()) {
        		buy.add(prices[i]);
        	}else if(prices[i] <= buy.peek()){
        		if(buy.size() > sell.size()) {
	        		buy.pop();
	        		buy.add(prices[i]);
        		}else {
        			buy.add(prices[i]);
        		}
        	}else if(prices[i] > buy.peek()) {
        		if(buy.size() > sell.size()) {
        			sell.add(prices[i]);
        			maxValue+=prices[i] - buy.peek();
        		}else {
        			if((sell.peek() - buy.peek()) < (prices[i] - buy.peek())){
        				maxValue-= sell.peek() - buy.peek();
        				maxValue+=prices[i] - buy.peek();
        			    sell.pop();
        			    sell.add(prices[i]);
        			}else {
        				buy.add(prices[i]);
        			}
        		}
        		
        	}
        }
        
        return maxValue;
    }
    
    
    public int maxProfit2(int[] prices) {
        int maxValue = 0;
        int buy = Integer.MAX_VALUE;
        int sell = 0; 
        
        for(int i = 0; i < prices.length; i++) { 
        	if(prices[i] <= buy){
	        	buy = prices[i];  
	        	sell=0;
        	}else if(prices[i] > buy) {
        		if(buy > sell) {
        			sell=prices[i];
        			maxValue+=prices[i] - buy;
        		}else {
        			if((sell - buy) < (prices[i] - buy)){
        				maxValue-= sell - buy;
        				maxValue+=prices[i] - buy;        			 
        			    sell=prices[i];
        			}else {
        				buy=prices[i];
        				sell=0;
        				
        			}
        		}        		
        	}
        }
        
        return maxValue;
    }
    //Peguei da internet
    public int maxProfit3(int[] prices) {
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) 
            profit += Math.max(0, prices[i] - prices[i - 1]);
        
        return profit;
    }

}
