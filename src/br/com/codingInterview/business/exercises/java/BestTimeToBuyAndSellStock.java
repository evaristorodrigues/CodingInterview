/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

/**
 * @author Evaristo
 *
 */
public class BestTimeToBuyAndSellStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
		int[] prices = {7,6,4,3,1,10,22};
		System.out.println(b.maxProfit(prices));
		
	}
	
    public int maxProfit(int[] prices) {
        int profit =0;
        int current = Integer.MAX_VALUE;
        
        for(int i =0; i < prices.length; i++) {
        	if(prices[i] <= current) {
        		current = prices[i];
        	}else if((prices[i] - current) > profit) {
        		profit = (prices[i] - current); 
        	}
        }
        
        return profit;
    }
    //peguei net
    public int maxProfit2(int[] prices) {
        int res = 0, min = Integer.MAX_VALUE;
        for(int p : prices) {
            res = Math.max(res, p - min);
            min = Math.min(p, min);
        }
        return res;
    }

}
