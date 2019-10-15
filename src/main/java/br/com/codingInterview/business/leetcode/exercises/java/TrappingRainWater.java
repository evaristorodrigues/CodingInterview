/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo
 *
 */
public class TrappingRainWater {

	/**
	 * 42. Trapping Rain Water
	 */
	public TrappingRainWater() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//
    public int trap2(int[] height) {
        int result =0;
        
        if(height == null || height.length ==0){
        	return 0;
        }
        int size = height.length;
        int[] left = new int[size];
        int[] right = new int[size];       
        
        int left_max =0;
        int right_max = 0;
        
        for(int i=0;i < size ; i++ ) {
        	if(height[i] > left_max) {
        		left_max = height[i];
        	}
        	left[i] = left_max;        	
        }
        
        for(int j=size -1;j >= 0; j-- ) {
        	if(height[j] > right_max) {
        		right_max = height[j];
        	}
        	right[j] = right_max;        	
        }
        
        for(int i=0; i < size; i++) {
        	int min = Math.min(left[i],right[i]);
        	result+=min-height[i];
        }
        
		return result ;
    }
    
    public int trap(int[] height) {
        if(height == null || height.length ==0){
        	return 0;
        }
    	
       int result=0;
       int left=0;
       int right= height.length -1;
       int left_max=0;
       int right_max=0;
       
       while(left < right) {
    	   if(height[left] < height[right]) {
    		   if(height[left] >= left_max) {
    			   left_max = height[left];
    		   }else {
    			   result+=left_max - height[left];
    		   }
    		   
    		   left++;
    	   }else {
    		   if(height[right] >= right_max ) {
    			   right_max = height[right];
    		   }else {	   
    			   result+=right_max - height[right];
    		   }
    		   right--;
    	   }
       }       
		return result ;
    }
}
