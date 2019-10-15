/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.Arrays;

/**
 * @author Evaristo
 *
 */
public class RotateArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RotateArray r = new RotateArray();
		int[] array = {1,2,3,4,5,6,7,8,9};
		r.rotate(array, 55);
		System.out.println(Arrays.toString(array));
		

	}
	
    public void rotate2(int[] nums, int 	k) {
        if(nums ==null || k < 1) {
        	return;
        }
        int prev = nums[0];
        for(int i =0; i < k; i++) {
        	for(int j =1; j <= nums.length; j++) {
        		if(j < nums.length ) {
	        		int aux = nums[j];
	        		nums[j] = prev;
	        		prev = aux;
        		}else {
	        		nums[0] = prev;	
	        	}
        	}
        }
       
    }	
    //Using reverse to help us
    public void rotate3(int[] nums, int 	k) {
        if(nums ==null || k < 1) { 
        	return;
        }
        int elements =nums.length -1;
        //using mod to set max position possible to use
        k %= elements;     
        //reverse the all elements
        helperReverse(nums, 0, elements);
        //reverse until the k shift
        helperReverse(nums, 0, k-1);
        //rever from k to the end
        helperReverse(nums, k, elements);       
    }

	private void helperReverse(int[] nums, int start, int end) {		
		while(start < end) {
			int aux = nums[end];
			nums[end] = nums[start];
			nums[start] = aux;
			start++;
			end--;
		}		
	}	
	
	  //Usando a forma em que pensamos
    public void rotate(int[] nums, int k) {
    	if(nums == null || k < 1) {
    		return;
    	}    	
		
    	for(int i = 0, count=0; count < nums.length; i++) {
    		int current=i;
    		int value=nums[i];
    		do {
	    		int aux = nums[(current + k) % nums.length];
	    		 nums[(current + k) % nums.length] = value;
	    		 current =(current + k) % nums.length;
	    		 value=aux;
	    		 count++;
    		}while(i !=current);    	
         }
    }	

}
