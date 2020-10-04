/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author evaristosrodrigues
 *
 */
public class MaximumAverageSubarrayI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {1,12,-5,-6,50,3};
		int k = 4;
		MaximumAverageSubarrayI m = new MaximumAverageSubarrayI();
		System.out.println(m.findMaxAverage(nums, k));

	}
	
    public double findMaxAverage(int[] nums, int k) {
    	
        int firstIndex =0;
        int lastIndex = k-1;
        double elements = k;
        int sum = 0;
        double media =0;
        
        for( int i =0; i < k; i++) {
        	sum+=nums[i];
        }
        media = sum/elements;
        
        while(lastIndex < nums.length-1) {        	
        	sum-=nums[firstIndex];        	
        	sum+=nums[++lastIndex];
        	firstIndex++;
        	media = Math.max(media, sum/elements);        	
        }
        return media;
    }

}
