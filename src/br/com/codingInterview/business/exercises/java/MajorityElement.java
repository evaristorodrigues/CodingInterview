/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Evaristo
 *
 */
public class MajorityElement {

	/**
	 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
	 */
	public static void main(String[] args) {
		MajorityElement m = new MajorityElement();
		int[] nums = {3,2,3,2,2,2,2,3,3,3,3,2,2,2,2,2,2,};
		System.out.println(m.majorityElement(nums));

	}
	
    public int majorityElement(int[] nums) {
    	
    	int majority = 0;
        int majorityQtd = 0;
    	Map<Integer, Integer> elemets = new HashMap<>();
    	
    	for(int i = 0; i < nums.length; i++) {
    		if(elemets.containsKey(nums[i])) {
    			int qtd = elemets.get(nums[i]) +1;
    			elemets.replace(nums[i], qtd);
    			if(qtd > majorityQtd) {
    				majorityQtd = qtd;
    				majority = nums[i];
    			}
    			if(qtd > nums.length/2) {
    				break;
    			}
    		}else {
    			elemets.put(nums[i], 1);
    			if(majorityQtd ==0) {
    				majorityQtd = 1;
    				majority = nums[i];
    			}
    		}
    	}
    	return majority;
      
    }

}
