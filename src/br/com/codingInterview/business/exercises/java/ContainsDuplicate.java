/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Evaristo
 *217. Contains Duplicate
 */
public class ContainsDuplicate {

	/**
	 * @param args
	 * Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
	 */
	public static void main(String[] args) {
		ContainsDuplicate c= new ContainsDuplicate();
		int[] nums = {1,1,2,3,4,5,6};
		System.out.println(c.containsDuplicate(nums));

	}
	
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for(int i =0; i < nums.length;i++) {
        	if(values.contains(nums[i])) {
        		return true;
        	}else {
        		values.add(nums[i]);
        	}
        }        
        return false;
    }
    
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for(int i =0; i < nums.length;i++) {
        	if(!values.add(nums[i])) {
        		return true;
        	}
        }        
        return false;
    }

}
