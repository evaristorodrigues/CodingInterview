/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.Arrays;

/**
 * @author Evaristo
 * 283. Move Zeroes
 */
public class MoveZeroes {

	/**
	 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
	 */
	public static void main(String[] args) {
		MoveZeroes m = new MoveZeroes();
		int[] nums = {0,0,1,0,3,12,0,0};
		m.moveZeroes3(nums );
		System.out.println(Arrays.toString(nums));
	}
	
    public void moveZeroes(int[] nums) {
    	int last = nums.length;
	        for(int i = nums.length - 2; i >=0; i--) {
	        	if(nums[i] == 0) {
                    helperMoveZeroes(i,nums, --last);
	        	}
	        }
    	}

	private void helperMoveZeroes(int i, int[] nums, int last) {
		for(int k = i; k < last; k++ ) {
		    int aux = nums[k];
		    nums[k] = nums[k +1];
		    nums[k +1] =  aux;		    
	    }   
    }
    
	public void moveZeroes2(int[] nums) {
        if(nums==null || nums.length==0)
            return;
        int index=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0) nums[index++] = nums[i];
        }
        
        for(int i=index; i<nums.length; i++){
            nums[i]=0;
        }
    }
	
	public void moveZeroes3(int[] nums) {
        if(nums==null || nums.length==0)
            return;
        for(int i=0,j=0; i<nums.length; i++){
        	if(nums[i]!=0) {
        		int aux =nums[j];
        		nums[j++] =nums[i];	
        		nums[i] = aux;
        	}
        }
        

    }

}
