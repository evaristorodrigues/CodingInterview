/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Evaristo
 * 268. Missing Number
 *
 */
public class MissingNumber {

	/**
	 * @param args
	 * 
	 *             Given an array containing n distinct numbers taken from 0, 1, 2,
	 *             ..., n, find the one that is missing from the array.
	 * 
	 *             Example 1:
	 * 
	 *             Input: [3,0,1] Output: 2 Example 2:
	 * 
	 *             Input: [9,6,4,2,3,5,7,0,1] Output: 8 Note: Your algorithm should
	 *             run in linear runtime complexity. Could you implement it using
	 *             only constant extra space complexity?
	 */
	public static void main(String[] args) {
		MissingNumber m = new MissingNumber();
		int[] nums = {3,0,1,2,4,5,7,8,6};
		System.out.println(m.missingNumber(nums ));

	}
	
    public int missingNumber(int[] nums) {
       int[] values  = new int[nums.length+1];
       int result =0; 
        for(int i = 0; i < nums.length; i++) {
        	values[nums[i]]++;
        }
        
        for(int i =0; i < values.length; i++) {
        	if(values[i] == 0) {
        		result =  i;
        		break;
        	}
        }        
         return result;
    }

}
