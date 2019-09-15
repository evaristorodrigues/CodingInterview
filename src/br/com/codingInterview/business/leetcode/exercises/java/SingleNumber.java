/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Evaristo
 *
 *136. Single Number
 */
public class SingleNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleNumber s = new SingleNumber();
		int[] nums = {31,1,3,1,33,11,3,33,11};
		System.out.println(s.singleNumber3(nums));       
	}
	
	/** 
	 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4*/
	
    public int singleNumber(int[] nums) {
    	Map<Integer, Integer> list = new HashMap<Integer, Integer>();
    	for(int i = 0; i <nums.length; i ++) {
    		if(list.containsKey(nums[i])) {
    			list.remove(nums[i]);
    		}else {
    			list.put(nums[i], nums[i]);
    		}
    	}    	
    	return (Integer) list.values().toArray()[0];
        
    }
    
    public int singleNumber2(int[] nums) {
    	Set<Integer> list = new HashSet<Integer>();
    	for(int i = 0; i <nums.length; i ++) {
    		if(list.contains(nums[i])) {
    			list.remove(nums[i]);
    		}else {
    			list.add(nums[i]);
    		}
    	}    	
    	return (Integer) list.iterator().next();        
    }
    
    public int singleNumber3(int[] nums) {
    	int xor=0;
    	for(int i = 0; i <nums.length; i ++) {
    		xor^=nums[i];
    	}    	
    	return xor;        
    }

}
