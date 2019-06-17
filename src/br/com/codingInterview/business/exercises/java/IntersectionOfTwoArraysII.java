/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Evaristo 350. Intersection of Two Arrays II
 */
public class IntersectionOfTwoArraysII {

	/**
	 * @param args Given two arrays, write a function to compute their intersection.
	 * 
	 *             Example 1:
	 * 
	 *             Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2,2] Example 2:
	 * 
	 *             Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [4,9] Note:
	 * 
	 *             Each element in the result should appear as many times as it
	 *             shows in both arrays. The result can be in any order. Follow up:
	 * 
	 *             What if the given array is already sorted? How would you optimize
	 *             your algorithm? What if nums1's size is small compared to nums2's
	 *             size? Which algorithm is better? What if elements of nums2 are
	 *             stored on disk, and the memory is limited such that you cannot
	 *             load all elements into the memory at once?
	 */
	public static void main(String[] args) {
		IntersectionOfTwoArraysII i = new IntersectionOfTwoArraysII();	
		int[] nums1 = {5,5,5,4,1};
        int[] nums2 = {5,4};
		System.out.println(Arrays.toString(i.intersect(nums1, nums2)));
	}
	//Não atende o que essa questão qer, mas retorna se aparecem na mesma posição.
    public int[] intersect3(int[] nums1, int[] nums2) {
        int[] result = {};
        int[] array1 = {} ;
        int[] array2= {};
        int positionLoop = 0;
        int positionArray=0;
        boolean finished = false;
        if(nums1 == null || nums2 ==null) {
        	return null;
        }        
        if(nums1.length > nums2.length) {
        	array1 = nums2;
        	array2 = nums1;
        	result = new int[nums2.length];
        }else {
        	array1 = nums1;
        	array2 = nums2;        	
        	result = new int[nums1.length];
        }       
        
        for( int i =0; i < array1.length; i++) {
        	for(int j = positionLoop ; j <array2.length; j++ ) {
        		if(array1[i] == array2[j]) {
        			result[positionArray++] =array1[i];
        			positionLoop = ++j;
        			break;
        		}else if(positionArray > 0) {
        			finished = true;        		
        		}
        	}
        	if(finished) {
        		break;
        	}
        }
        
        return positionArray > 0?Arrays.copyOfRange(result, 0, positionArray):new int[0];
    }
    
    public int[] intersect2(int[] nums1, int[] nums2) {
    	 Map<Integer, Integer> values = new HashMap<>();
    	 int[] result;
    	 List<Integer> aux= new ArrayList<>();
         if(nums1 == null || nums2 ==null) {
         	return null;
         } 
         int[] array1 = {} ;
         int[] array2= {};
         if(nums1.length > nums2.length) {
         	array1 = nums2;
         	array2 = nums1;
         }else {
         	array1 = nums1;
         	array2 = nums2;        	
         } 
         for( int i =0; i < array2.length; i++) {
        	 values.put(array2[i],values.getOrDefault(array2[i], 0)+1);
         }
         
         for(int j =0; j < array1.length; j++) {
        	 if(values.containsKey(array1[j])) {
        		 if(values.get(array1[j]) == 1) {
        			 values.remove(array1[j]);
        		 }else {
                     values.replace(array1[j],values.getOrDefault(array1[j], 0)-1); 			 
        		 }
        		 aux.add(array1[j]);        		 
        	 }
         }
         result = new int[aux.size()];
         for(int i =0; i < aux.size(); i++) {
        	 result[i] = aux.get(i);
         }
    	return result; 
    }
    
    public int[] intersect4(int[] nums1, int[] nums2) {
   	 Map<Integer, Integer> values = new HashMap<>();
   	 int[] result;
   	 List<Integer> aux= new ArrayList<>();
        if(nums1 == null || nums2 ==null) {
        	return null;
        } 
        int[] array1 = {} ;
        int[] array2= {};
        if(nums1.length > nums2.length) {
        	array1 = nums2;
        	array2 = nums1;
        }else {
        	array1 = nums1;
        	array2 = nums2;        	
        } 
        for( int i =0; i < array2.length; i++) {
       	 values.put(array2[i],values.getOrDefault(array2[i], 0)+1);
        }
        
        for(int j =0; j < array1.length; j++) {
       	 if(values.containsKey(array1[j]) && values.get(array1[j]) > 0) {
             values.replace(array1[j],values.getOrDefault(array1[j], 0)-1); 			 
       		 aux.add(array1[j]);        		 
       	 }
        }
        result = new int[aux.size()];
        for(int i =0; i < aux.size(); i++) {
       	 result[i] = aux.get(i);
        }
   	return result; 
   }
    
    public int[] intersect(int[] nums1, int[] nums2) {
    	if(nums1 == null || nums2 == null ) {
    		return null;
    	}
    	List<Integer> aux = new ArrayList<>();
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);  
    	int[] result = {};
    	int j=0;
        int i=0;        
        while(i < nums1.length && j < nums2.length) {        	
        	if(nums1[i] == nums2[j]) {
        		aux.add(nums1[i]);
        		j++;
        		i++;
        	}else if(nums1[i] > nums2[j]){
        		j++;
        	}else {
        		i++;
        	}        	
        }
        result = new int[aux.size()];
        for(int k=0; k < aux.size(); k++) {
        	result[k] = aux.get(k);
        }        
        return result;
    }

   

}
