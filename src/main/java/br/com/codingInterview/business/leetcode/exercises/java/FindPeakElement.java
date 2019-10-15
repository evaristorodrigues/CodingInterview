/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo
 *162. Find Peak Element
 */
public class FindPeakElement {

	/**
	 * A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity.

Accepted
	 */
	public FindPeakElement() {
}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {1,2,1,3,5,7,8};
		System.out.println( new FindPeakElement().findPeakElement(nums));
			
	}
	
    public int findPeakElement2(int[] nums) {    
    	int left =0;
    	int right = nums.length-1;
    	while(left < right) {
    	   int mid = left + ( right - left)/2;
    	   if(nums[mid] > nums[mid+1]) {
    		   right = mid;
    	   }else {
    		   left = mid+1;
    	   }
    	}
       return left;
    }

    public int findPeakElement(int[] nums) {    
    	return helper(nums, 0, nums.length-1);
    }

	private int helper(int[] nums, int left, int right) {
		if(left == right) {
			return left;
		}
		int mid = left + (right - left)/2;
		if(nums[mid]> nums[mid + 1]) {
			return helper(nums, left, mid);
		}else {
			return helper(nums, mid+1, right);
		}
	}


}
